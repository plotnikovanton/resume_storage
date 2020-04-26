package ru.javaops.webapp.storage.serializer;

import ru.javaops.webapp.model.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataStreamSerializer implements StreamSerializer {
    @Override
    public void doWrite(OutputStream os, Resume resume) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(os)) {
            dos.writeUTF(resume.getUuid());
            dos.writeUTF(resume.getFullName());
            Map<ContactType, String> contacts = resume.getContacts();
            dos.writeInt(contacts.size());
            for (Map.Entry<ContactType, String> entry : contacts.entrySet()) {
                dos.writeUTF(entry.getKey().name());
                dos.writeUTF(entry.getValue());
            }
            writeSections(dos, resume.getSections());
        }
    }

    @Override
    public Resume doRead(InputStream is) throws IOException {
        try (DataInputStream dis = new DataInputStream(is)) {
            Resume resume = new Resume(dis.readUTF(), dis.readUTF());
            int size = dis.readInt();
            for (int i = 0; i < size; i++) {
                resume.addContact(ContactType.valueOf(dis.readUTF()), dis.readUTF());
            }
            readSections(dis, resume);

            return resume;
        }
    }

    private void readSections(DataInputStream dis, Resume resume) throws IOException {
        int size = dis.readInt();
        for (int i = 0; i < size; i++) {
            SectionType st = SectionType.valueOf(dis.readUTF());
            resume.addSection(st, readSection(dis, st));
        }
    }

    private Section readSection(DataInputStream dis, SectionType st) throws IOException {
        if (st.equals(SectionType.PERSONAL) || st.equals(SectionType.OBJECTIVE)) {
            return new TextSection(dis.readUTF());
        } else if (st.equals(SectionType.ACHIEVEMENT) || st.equals(SectionType.QUALIFICATIONS)) {
            return new ListSection(readList(dis, dis::readUTF));
        } else {
            return new OrganizationSection(readList(dis, () -> new Organization(new Link(dis.readUTF(), dis.readUTF()),
                    readList(dis, () -> new Organization.Position(readLD(dis), readLD(dis), dis.readUTF(), dis.readUTF())))));
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
        dos.writeInt(sectionMap.size());
        for (Map.Entry<SectionType, Section> entry : sectionMap.entrySet()) {
            SectionType st = entry.getKey();
            Section section = entry.getValue();
            dos.writeUTF(st.name());
            writeSection(dos, st, section);
        }
    }

    private void writeSection(DataOutputStream dos, SectionType st, Section section) throws IOException {
        if (st.equals(SectionType.PERSONAL) || st.equals(SectionType.OBJECTIVE)) {
            dos.writeUTF(((TextSection) section).getContent());
        } else if (st.equals(SectionType.ACHIEVEMENT) || st.equals(SectionType.QUALIFICATIONS)) {
            writeList(dos, ((ListSection) section).getItems());
        } else {
            writeOrganizations(dos, ((OrganizationSection) section).getOrganizations());
        }
    }

    private void writeList(DataOutputStream dos, List<String> items) throws IOException {
        dos.writeInt(items.size());
        for (String item : items) {
            dos.writeUTF(item);
        }
    }

    private void writeOrganizations(DataOutputStream dos, List<Organization> organizations) throws IOException {
        dos.writeInt(organizations.size());
        for (Organization organization : organizations) {
            dos.writeUTF(organization.getHomePage().getName());
            dos.writeUTF(organization.getHomePage().getUrl());
            writePositions(dos, organization.getPositions());
        }
    }

    private void writePositions(DataOutputStream dos, List<Organization.Position> positions) throws IOException {
        dos.writeInt(positions.size());
        for (Organization.Position position : positions) {
            writeLD(dos, position.getStartDate());
            writeLD(dos, position.getEndDate());
            dos.writeUTF(position.getTitle());
            dos.writeUTF(position.getDescription());
        }
    }
}
