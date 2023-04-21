package y23.m04.d20;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.Collator;
import java.util.Objects;

public class Management {
    private final Participant[] participants;
    private int participantCount;

    public Management() {
        participants = new Participant[50];
        participantCount = 0;
    }

    public boolean loadFromFile(Path path) {
        try {
            if (!Files.exists(path) || !Files.isRegularFile(path)) {
                Files.createFile(path);
                return true;
            }
            var lines = Files.readAllLines(path);
            for (var line : lines) {
                var parts = line.split(" ");
                if (parts.length == 0 || (parts.length == 1 && parts[0].isBlank())) {
                    continue;
                }
                if (parts.length != 2 || parts[0].isBlank() || parts[1].isBlank()) {
                    return false;
                }
                if (!addParticipant(new Participant(parts[1], parts[0]))) {
                    return false;
                }
            }
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public boolean saveToFile(Path path) {
        try (var output = new PrintWriter(new FileOutputStream(path.toFile(), false))) {
            for (int i = 0; i < participantCount; i++) {
                output.println(participants[i].getSurname() + " " + participants[i].getName());
            }
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public boolean isFilled() {
        return participantCount >= 50;
    }

    public boolean isRegistered(Participant participant) {
        for (int i = 0; i < participantCount; i++) {
            if (Objects.equals(participant, participants[i])) {
                return true;
            }
        }
        return false;
    }

    public boolean addParticipant(Participant participant) {
        if (isRegistered(participant)) {
            return true;
        }
        if (isFilled()) {
            return false;
        }
        participants[participantCount++] = participant;
        return true;
    }

    public boolean removeParticipant(int index) {
        if (index < 0 || index >= participantCount) {
            return false;
        }
        if (index == participantCount - 1) {
            participantCount--;
            return true;
        }
        System.arraycopy(participants, index + 1, participants, index, participantCount - index - 1);
        participantCount--;
        return true;
    }

    public void sortByName() {
        Collator collator = Collator.getInstance();
        for (int start = 0; start < participantCount; start++) {
            int best = start;
            for (int i = start; i < participantCount; i++) {
                if (participants[i].compareByName(participants[best]) < 0) {
                    best = i;
                }
            }
            Participant temp = participants[start];
            participants[start] = participants[best];
            participants[best] = temp;
        }
    }

    public void sortBySurname() {
        Collator collator = Collator.getInstance();
        for (int start = 0; start < participantCount; start++) {
            int best = start;
            for (int i = start; i < participantCount; i++) {
                if (participants[i].compareBySurname(participants[best]) < 0) {
                    best = i;
                }
            }
            Participant temp = participants[start];
            participants[start] = participants[best];
            participants[best] = temp;
        }
    }

    public int getMaxParticipantCount() {
        return participants.length;
    }

    public int getParticipantCount() {
        return participantCount;
    }

    public Participant getParticipant(int index) {
        return participants[index];
    }
}
