package com.tareas.tarea8;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class tarea8 {

    @RequestMapping("/")
    public String addOriginal() {
        return LinkedList.addOriginalWorkers();
    }

    @RequestMapping("/list")
    public String print() {
        return LinkedList.listWorkers();
    }

    @RequestMapping("/add")
    public String add(int ss_number, String worker, String position, int days) {
        return LinkedList.addWorker(ss_number, worker, position, days);
    }

    @RequestMapping("/empty")
    public String empty() {
        return LinkedList.emptyList();
    }
}

class LinkedList {

    static LinkedList list = new LinkedList();
    Node head;
    Node sorted_head;

    static class Node {
        int social_security;
        String name;
        String entidad_anunciada;
        int days_worked;
        Node next;
        Node sorted_next;

        Node(int ss_val, String worker_name, String anuncio_val, int work_days) {
            social_security = ss_val;
            name = worker_name;
            entidad_anunciada = anuncio_val;
            days_worked = work_days;
            next = null;
            sorted_next = null;
        }
    }

    public static String addOriginalWorkers() {
        addWorker(12345, "John", "Publicity", 5);
        addWorker(54321, "Mike", "Marketing", 4);
        addWorker(789, "Alex", "Distribution", 15);
        addWorker(345, "Rob", "Design", 22);
        return "Added Successfully";
    }

    public static String listWorkers() {
        Node current = list.head;
        Node current_sorted = list.sorted_head;
        String result = "Queue: " + "<br>";
        String sorted_result = "<br>" + "Sorted List: " + "<br>";

        while (current != null) {
            result = result + "Social Security Number: " + current.social_security + " Work: " + current.entidad_anunciada + "<br>";
            current = current.next;
        }

        while (current_sorted != null) {
            sorted_result = sorted_result + "Social Security Number: " + current_sorted.social_security + " Name: " + current_sorted.name + " Days: " + current_sorted.days_worked + "<br>";
            current_sorted = current_sorted.sorted_next;
        }
        return result + sorted_result;
    }

    public static String addWorker(int ss, String name, String entidad_val, int days_amount) {
        Node current = list.head;
        while (current != null) {
            if (current.social_security == ss) {
                updateWorker(ss, name, entidad_val, days_amount);
                return "Updated Successfully";
            }
            current = current.next;
        }
        Node new_n = new Node(ss, name, entidad_val, days_amount);
        new_n.next = null;
        new_n.sorted_next = null;
        if (list.head == null) {
            list.head = new_n;
        }
        else {
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new_n;
        }
        if (list.sorted_head == null || list.sorted_head.social_security >= new_n.social_security) {
            new_n.sorted_next = list.sorted_head;
            list.sorted_head = new_n;
        }
        else {
            Node sorted_last = list.sorted_head;
            while (sorted_last.sorted_next != null && sorted_last.sorted_next.social_security < new_n.social_security) {
                sorted_last = sorted_last.sorted_next;
            }
            new_n.sorted_next = sorted_last.sorted_next;
            sorted_last.sorted_next = new_n;
        }
        return "Added Successfully";
    }

    public static String emptyList() {
        String result = "";
        while (list.head != null) {
            Node prev_last = list.head;
            if (prev_last.next == null) {
                result = result + "Social Security Number: " + prev_last.social_security + " Name: " + prev_last.name + " Work: " + prev_last.entidad_anunciada + " Days: " + prev_last.days_worked + "<br>";
                list.head = null;
            }
            else {
                while (prev_last.next.next != null) {
                    prev_last = prev_last.next;
                }
                Node node = prev_last.next;
                prev_last.next = null;
                result = result + "Social Security Number: " + node.social_security + " Name: " + node.name + " Work: " + node.entidad_anunciada + " Days: " + node.days_worked + "<br>";
            }
        }
        return result;
    }

    public static void updateWorker(int ss, String name, String entidad_val, int days_amount) {
        Node current = list.head;
        while (current != null) {
            if (current.social_security == ss) {
                current.name = name;
                current.entidad_anunciada = entidad_val;
                current.days_worked = days_amount;
            }
            current = current.next;
        }
    }
}
