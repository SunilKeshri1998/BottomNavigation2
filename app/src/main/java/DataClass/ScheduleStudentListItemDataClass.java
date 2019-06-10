package DataClass;

public class

ScheduleStudentListItemDataClass {

    String subject,teacher;
    int slot;
    Boolean classCancelled;


    public ScheduleStudentListItemDataClass(String subject, String teacher, int slot,Boolean classCancelled) {
        this.subject = subject;
        this.teacher = teacher;
        this.slot = slot;
        this.classCancelled=classCancelled;
    }

    public String getSubject() {
        return subject;
    }

    public String getTeacher() {
        return teacher;
    }

    public int getSlot() {
        return slot;
    }

    public Boolean getClassCancelled() {
        return classCancelled;
    }
}
