package ru.javaops.webapp.storage.serializer;

import ru.javaops.webapp.model.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import static ru.javaops.webapp.model.SectionType.*;

public class DataStreamSerializer implements StreamSerializer {
    @Override
    public void doWrite(OutputStream os, Resume resume) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(os)) {
            dos.writeUTF(resume.getUuid());
            dos.writeUTF(resume.getFullName());
            Map<ContactType, String> contacts = resume.getContacts();
            writeCollection(dos, contacts.entrySet(), entry -> {
                dos.writeUTF(entry.getKey().name());
                dos.writeUTF(entry.getValue());
            });
            writeSections(dos, resume.getSections());
        }
    }

    @Override
    public Resume doRead(InputStream is) throws IOException {
        try (DataInputStream dis = new DataInputStream(is)) {
            Resume resume = new Resume(dis.readUTF(), dis.readUTF());
            readNext(dis, () -> resume.setContact(ContactType.valueOf(dis.readUTF()), dis.readUTF()));
            readSections(dis, resume);
            return resume;
        }
    }

    private void readSections(DataInputStream dis, Resume resume) throws IOException {
        readNext(dis, () -> {
            SectionType st = valueOf(dis.readUTF());
            resume.setSection(st, readSection(dis, st));
        });
    }

    private void readNext(DataInputStream dis, Executor executor) throws IOException {
        int size = dis.readInt();
        for (int i = 0; i < size; i++) {
           executor.execute();
        }
    }

    private interface Executor {
        void execute() throws IOException;
    }

    private Section readSection(DataInputStream dis, SectionType st) throws IOException {
        switch (st) {
            case PERSONAL:
            case OBJECTIVE:
                return new TextSection(dis.readUTF());
            case ACHIEVEMENT:
            case QUALIFICATIONS:
                return new ListSection(readList(dis, dis::readUTF));
            case EDUCATION:
            case EXPERIENCE:
                return new OrganizationSection(readList(dis, () -> new Organization(new Link(dis.readUTF(), dis.readUTF()),
                        readList(dis, () -> new Organization.Position(readLD(dis), readLD(dis), dis.readUTF(), dis.readUTF())))));
            default:
                return null;
        }
    }

    private <T> List<T> readList(DataInputStream dis, ItemReader<T> ir) throws IOException {
        int size = dis.readInt();
        List<T> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(ir.read());
        }
        return list;
    }

    private interface ItemReader<T> {
        T read() throws IOException;
    }

    private LocalDate readLD(DataInputStream dis) throws IOException {
        return LocalDate.of(dis.readInt(), dis.readInt(), 1);
    }

    private void writeLD(DataOutputStream dos, LocalDate ld) throws IOException {
        dos.writeInt(ld.getYear());
        dos.writeInt(ld.getMonthValue());
    }

    private void writeSections(DataOutputStream dos, Map<SectionType, Section> sectionMap) throws IOException {
        writeCollection(dos, sectionMap.entrySet(), entry -> {
            SectionType st = entry.getKey();
            Section section = entry.getValue();
            dos.writeUTF(st.name());
            writeSection(dos, st, section);
        });
    }

    private void writeSection(DataOutputStream dos, SectionType st, Section section) throws IOException {
        switch (st) {
            case PERSONAL:
            case OBJECTIVE:
                dos.writeUTF(((TextSection) section).getContent());
                break;
            case ACHIEVEMENT:
            case QUALIFICATIONS:
                writeCollection(dos, ((ListSection) section).getItems(), dos::writeUTF);
                break;
            case EDUCATION:
            case EXPERIENCE:
                writeCollection(dos, ((OrganizationSection) section).getOrganizations(), org -> {
                    dos.writeUTF(org.getHomePage().getName());
                    dos.writeUTF(org.getHomePage().getUrl());
                    writeCollection(dos, org.getPositions(), pos -> {
                        writeLD(dos, pos.getStartDate());
                        writeLD(dos, pos.getEndDate());
                        dos.writeUTF(pos.getTitle());
                        dos.writeUTF(pos.getDescription());
                    });
                });
                break;
        }
    }

    private <T> void writeCollection(DataOutputStream dos, Collection<T> collection, ItemWriter<T> writer) throws IOException {
        dos.writeInt(collection.size());
        for (T item : collection) {
            writer.write(item);
        }
    }

    private interface ItemWriter<T> {
        void write(T t) throws IOException;
    }
}
