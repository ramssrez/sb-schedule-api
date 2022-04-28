package com.at.internship.schedule.serialization.csv;

import com.at.internship.schedule.constants.AppConstants;
import com.at.internship.schedule.domain.Appointment;
import com.at.internship.lib.serialization.ISerializer;
import com.at.internship.lib.serialization.csv.CsvSerializer;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.at.internship.lib.serialization.csv.CsvSerializer.Row;

public class AppointmentSerializer implements ISerializer<Appointment> {
    private static final String FILE_NAME = "Contact.csv";

    private String getFileName() {
        return AppConstants.SERIALIZATION_PATH + FILE_NAME;
    }

    public void serialize(List<Appointment> list) throws IOException {
        String fileName = getFileName();
        CsvSerializer serializer = new CsvSerializer();
        serializer.setHeaders(new Row("ID", "Contact ID", "Time", "Subject"));
        for(Appointment a : list) {
            serializer.addRow(new Row(
                    a.getId(),
                    a.getContactId(),
                    a.getTime(),
                    a.getSubject()
            ));
        }

        try (PrintWriter writter = new PrintWriter(fileName, StandardCharsets.UTF_8)) {
            for(String line : serializer) {
                writter.println(line);
            }
        }
    }

    public List<Appointment> deserialize() {
        String fileName = getFileName();
        List<Appointment> list = new ArrayList<>();
        try (Scanner scanner = new Scanner(fileName)) {
            // Skip headers
            if (scanner.hasNextLine()) scanner.nextLine();
            while (scanner.hasNextLine()) {
                Row row = Row.deserialize(scanner.nextLine());
                Appointment contact = new Appointment();
                contact.setId(Integer.parseInt(row.getValueAt(0)));
                contact.setContactId(Integer.parseInt(row.getValueAt(1)));
                contact.setTime(LocalDateTime.parse(row.getValueAt(2)));
                contact.setSubject(row.getValueAt(3));
                list.add(contact);
            }
        } catch (Exception e) {
            System.err.printf("Table reading failed due to error: %s: %s%n", e.getClass().getName(), e.getMessage());
            System.err.println("Changes may not saved if the error persists");
        }
        return  list;
    }

}
