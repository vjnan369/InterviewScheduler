import java.awt.print.PrinterIOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Test {
    public static void main(String args[]) throws ParseException {
        Test t = new Test();

        Scanner s = new Scanner(System.in);
        List<PriorityCandiate> candidatesList = new ArrayList<PriorityCandiate>();
        candidatesList.add(new PriorityInterview("Sam", getDate("31-Dec-1998 8:50"), "100012", "900"));
        candidatesList.add(new PriorityInterview("abcd2", getDate("31-Dec-1998 8:55"), "100013", "900"));
        candidatesList.add(new PriorityInterview("raj", getDate("31-Dec-1998 9:00"), "100014","900"));
        candidatesList.add(new PriorityInterview("deepak", getDate("31-Dec-1998 9:50"), "100015", "900"));
        candidatesList.add(new PriorityInterview("samarth", getDate("31-Dec-1998 8:40"), "100016", "1000"));
        candidatesList.add(new PriorityInterview("krishna", getDate("31-Dec-1998 9:40"), "100017","1000"));
        candidatesList.add(new PriorityInterview("hari", getDate("31-Dec-1998 10:00"), "100018", "1000"));
        candidatesList.add(new PriorityInterview("arjun", getDate("31-Dec-1998 11:50"), "100019", "1000"));
        candidatesList.add(new PriorityInterview("chandan", getDate("31-Dec-1998 9:50"), "100020", "1100"));
        candidatesList.add(new PriorityInterview("chiru", getDate("31-Dec-1998 10:50"), "100021", "1100"));
        candidatesList.add(new PriorityInterview("chaitanya", getDate("31-Dec-1998 11:50"), "100022", "1100"));
        candidatesList.add(new PriorityInterview("rahul", getDate("31-Dec-1998 12:45"), "100023", "1100"));

        Queue<PriorityCandiate> priorityQueue = new PriorityQueue<PriorityCandiate>();
        filterwithPriority(candidatesList, priorityQueue);

        System.out.println("Printing all candidate details with priority");
        Iterator iterator = priorityQueue.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    static Date getDate(String date) throws ParseException {
        Date newDate = new SimpleDateFormat("dd-MMM-yyyy HH:mm").parse(date);
        return newDate;
    }

    static void filterwithPriority(List<PriorityCandiate> candidatesList, Queue<PriorityCandiate> priorityQueue) throws ParseException {
        Date firstSlot = getDate("31-Dec-1998 9:00");
        Date secondSlot = getDate("31-Dec-1998 10:00");
        Date thirdSlot = getDate("31-Dec-1998 11:00");
        for(PriorityCandiate priorityInterview : candidatesList) {
            if(priorityInterview.getInterviewDate().compareTo(firstSlot) <= 0) {
                priorityQueue.add(priorityInterview);
            }
        }

        for(PriorityCandiate priorityInterview : candidatesList) {
            if(priorityInterview.getInterviewDate().compareTo(secondSlot) <= 0 &&  priorityInterview.getInterviewDate().compareTo(firstSlot) > 0) {
                priorityQueue.add(priorityInterview);
            }
        }
        for(PriorityCandiate priorityInterview : candidatesList) {
            if(priorityInterview.getInterviewDate().compareTo(thirdSlot) <= 0 && priorityInterview.getInterviewDate().compareTo(secondSlot) > 0) {
                priorityQueue.add(priorityInterview);
            }
        }
        for(PriorityCandiate priorityInterview : candidatesList) {
            if((priorityInterview.getInterviewDate().compareTo(firstSlot) > 0 && priorityInterview.getInterviewDate().compareTo(secondSlot) < 0 && priorityInterview.getInterviewSlot().equals("900"))) {
                priorityQueue.add(priorityInterview);
            }
        }
        for(PriorityCandiate priorityInterview : candidatesList) {
            if((priorityInterview.getInterviewDate().compareTo(secondSlot) > 0 && priorityInterview.getInterviewDate().compareTo(thirdSlot) < 0 && priorityInterview.getInterviewSlot().equals("1000"))) {
                priorityQueue.add(priorityInterview);
            }
        }
        for(PriorityCandiate priorityInterview : candidatesList) {
            if((priorityInterview.getInterviewDate().compareTo(thirdSlot) > 0 && priorityInterview.getInterviewSlot().equals("1100"))) {
                priorityQueue.add(priorityInterview);
            }
        }
    }
}
