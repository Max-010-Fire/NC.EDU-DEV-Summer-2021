package max.springbootapp.port.adapter.requests;

import max.springbootapp.domain.model.entities.Task;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TaskRequest {

    private String userId = "0";
    private String title = "";
    private String description = "";
    private String taskStatusId = "0";
    private String dueDateTime = "2009-06-04T22:00:00";

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTaskStatusId(String taskStatusId) {
        this.taskStatusId = taskStatusId;
    }

    public void setDueDateTime(String dueDateTime) {
        this.dueDateTime = dueDateTime;
    }

    public String getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getTaskStatusId() {
        return taskStatusId;
    }

    public String getDueDateTime() {
        return dueDateTime;
    }

    public Task requestToTask() {
        Task task = new Task();

        task.setUserId(Integer.parseInt(userId));
        task.setTitle(title);
        task.setDescription(description);
        task.setTaskStatusId(Integer.parseInt(taskStatusId));
        task.setCreationDateTime(new java.util.Date());

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        try {
            dueDateTime = dueDateTime.replace("T", " ");
            task.setDueDateTime(dateFormat.parse(dueDateTime));
            System.out.println(dueDateTime + task.getDueDateTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println(task);

        return task;
    }

    public static TaskRequest taskToTaskRequest(Task task) {
        TaskRequest taskRequest = new TaskRequest();
        taskRequest.userId = (Long.toString(task.getUserId()));
        taskRequest.title = task.getTitle();
        taskRequest.description = task.getDescription();
        taskRequest.taskStatusId = Long.toString(task.getTaskStatusId());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        String dueDateTime = dateFormat.format(task.getDueDateTime());
        taskRequest.setDueDateTime(dueDateTime.replace(" ", "T"));
        return taskRequest;
    }
}
