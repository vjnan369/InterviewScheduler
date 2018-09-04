import java.util.Date;

public class PriorityInterview implements PriorityCandiate , Comparable<PriorityInterview>{
    String name;
    Date date;
    String candidateId;
    String interviewSlot;

    PriorityInterview(String name, Date date, String candidateId, String interviewSlot) {
        this.name = name;
        this.date = date;
        this.candidateId = candidateId;
        this.interviewSlot = interviewSlot;
    }

    @Override
    public int compareTo(PriorityInterview o) {
        return 0;
    }

    public String getName() {
        return name;
    }

    public String getCandidateId() {
        return candidateId;
    }

    public String getInterviewSlot() {
        return interviewSlot;
    }

    public Date getInterviewDate() {
        return date;
    }
}
