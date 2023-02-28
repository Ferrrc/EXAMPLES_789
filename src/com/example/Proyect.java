package com.example;
import java.io.*;
import java.util.*;

public class Proyect {
    public static void main(String[] args) {

    }


    public class ToDoList {
        private static final String FILE_NAME = "todolist.txt";
        private static final String TASK_SEPARATOR = ",";
        private static final String LINE_SEPARATOR = System.getProperty("line.separator");

        private Map<Integer, String> tasks = new HashMap<Integer, String>();
        private List<Integer> pendingTasks = new ArrayList<Integer>();

        public void load() throws IOException {
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader(FILE_NAME));
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] fields = line.split(TASK_SEPARATOR);
                    int id = Integer.parseInt(fields[0]);
                    String description = fields[1];
                    tasks.put(id, description);
                    if (!fields[2].equals("completed")) {
                        pendingTasks.add(id);
                    }
                }
            } finally {
                if (reader != null) {
                    reader.close();
                }
            }
        }

        public void save() throws IOException {
            PrintWriter writer = null;
            try {
                writer = new PrintWriter(new FileWriter(FILE_NAME));
                for (Map.Entry<Integer, String> entry : tasks.entrySet()) {
                    int id = entry.getKey();
                    String description = entry.getValue();
                    String status = pendingTasks.contains(id) ? "pending" : "completed";
                    writer.printf("%d%s%s%s%s", id, TASK_SEPARATOR, description, TASK_SEPARATOR, status);
                    writer.print(LINE_SEPARATOR);
                }
            } finally {
                if (writer != null) {
                    writer.close();
                }
            }
        }

        public void addTask(String description) {
            int id = tasks.size() + 1;
            tasks.put(id, description);
            pendingTasks.add(id);
        }

        public void completeTask(int id) {
            if (tasks.containsKey(id)) {
                pendingTasks.remove((Integer) id);
            } else {
                throw new IllegalArgumentException("Invalid task id: " + id);
            }
        }

        public void listPendingTasks() {
            System.out.println("Pending tasks:");
            for (int id : pendingTasks) {
                System.out.printf("%d: %s%n", id, tasks.get(id));
            }
        }

        public void main(String[] args) {
            ToDoList todo = new ToDoList();
            try {
                todo.load();
            } catch (IOException e) {
                System.err.println("Error loading tasks: " + e.getMessage());
            }
            Scanner scanner = new Scanner(System.in);
            boolean exit = false;
            while (!exit) {
                System.out.println("Enter command (add, complete, list, exit):");


            }
        }
    }
}