package teammates.common.datatransfer;

import java.util.LinkedHashMap;
import java.util.Map;

import teammates.common.datatransfer.attributes.AccountAttributes;
import teammates.common.datatransfer.attributes.AdminEmailAttributes;
import teammates.common.datatransfer.attributes.CourseAttributes;
import teammates.common.datatransfer.attributes.EntityAttributes;
import teammates.common.datatransfer.attributes.FeedbackQuestionAttributes;
import teammates.common.datatransfer.attributes.FeedbackResponseAttributes;
import teammates.common.datatransfer.attributes.FeedbackResponseCommentAttributes;
import teammates.common.datatransfer.attributes.FeedbackSessionAttributes;
import teammates.common.datatransfer.attributes.InstructorAttributes;
import teammates.common.datatransfer.attributes.StudentAttributes;
import teammates.common.datatransfer.attributes.StudentProfileAttributes;
import teammates.storage.entity.BaseEntity;

/**
 * Holds a bundle of *Attributes data transfer objects.
 * This class is mainly used for serializing JSON strings.
 */
public class DataBundle {
    private Map<String, AccountAttributes> accounts = new LinkedHashMap<>();
    private Map<String, CourseAttributes> courses = new LinkedHashMap<>();
    private Map<String, InstructorAttributes> instructors = new LinkedHashMap<>();
    private Map<String, StudentAttributes> students = new LinkedHashMap<>();
    private Map<String, FeedbackSessionAttributes> feedbackSessions = new LinkedHashMap<>();
    private Map<String, FeedbackQuestionAttributes> feedbackQuestions = new LinkedHashMap<>();
    private Map<String, FeedbackResponseAttributes> feedbackResponses = new LinkedHashMap<>();
    private Map<String, FeedbackResponseCommentAttributes> feedbackResponseComments = new LinkedHashMap<>();
    private Map<String, StudentProfileAttributes> profiles = new LinkedHashMap<>();
    private Map<String, AdminEmailAttributes> adminEmails = new LinkedHashMap<>();

    /**
     * Sanitize each attribute in the dataBundle for saving.
     */
    public void sanitizeForSaving() {
        sanitizeMapForSaving(getAccounts());
        sanitizeMapForSaving(getCourses());
        sanitizeMapForSaving(getInstructors());
        sanitizeMapForSaving(getStudents());
        sanitizeMapForSaving(getFeedbackSessions());
        sanitizeMapForSaving(getFeedbackQuestions());
        sanitizeMapForSaving(getFeedbackResponses());
        sanitizeMapForSaving(getFeedbackResponseComments());
        sanitizeMapForSaving(getProfiles());
        sanitizeMapForSaving(getAdminEmails());
    }

    /**
     * Sanitize each attribute in the {@code map} for saving.
     */
    private <T extends EntityAttributes<? extends BaseEntity>> void sanitizeMapForSaving(Map<String, T> map) {
        for (T attribute : map.values()) {
            attribute.sanitizeForSaving();
        }
    }

    public Map<String, AccountAttributes> getAccounts() {
        return accounts;
    }

    public void setAccounts(Map<String, AccountAttributes> accounts) {
        this.accounts = accounts;
    }

    public Map<String, CourseAttributes> getCourses() {
        return courses;
    }

    public void setCourses(Map<String, CourseAttributes> courses) {
        this.courses = courses;
    }

    public Map<String, InstructorAttributes> getInstructors() {
        return instructors;
    }

    public void setInstructors(Map<String, InstructorAttributes> instructors) {
        this.instructors = instructors;
    }

    public Map<String, StudentAttributes> getStudents() {
        return students;
    }

    public void setStudents(Map<String, StudentAttributes> students) {
        this.students = students;
    }

    public Map<String, FeedbackSessionAttributes> getFeedbackSessions() {
        return feedbackSessions;
    }

    public void setFeedbackSessions(Map<String, FeedbackSessionAttributes> feedbackSessions) {
        this.feedbackSessions = feedbackSessions;
    }

    public Map<String, FeedbackQuestionAttributes> getFeedbackQuestions() {
        return feedbackQuestions;
    }

    public void setFeedbackQuestions(Map<String, FeedbackQuestionAttributes> feedbackQuestions) {
        this.feedbackQuestions = feedbackQuestions;
    }

    public Map<String, FeedbackResponseAttributes> getFeedbackResponses() {
        return feedbackResponses;
    }

    public void setFeedbackResponses(Map<String, FeedbackResponseAttributes> feedbackResponses) {
        this.feedbackResponses = feedbackResponses;
    }

    public Map<String, FeedbackResponseCommentAttributes> getFeedbackResponseComments() {
        return feedbackResponseComments;
    }

    public void setFeedbackResponseComments(Map<String, FeedbackResponseCommentAttributes> feedbackResponseComments) {
        this.feedbackResponseComments = feedbackResponseComments;
    }

    public Map<String, StudentProfileAttributes> getProfiles() {
        return profiles;
    }

    public void setProfiles(Map<String, StudentProfileAttributes> profiles) {
        this.profiles = profiles;
    }

    public Map<String, AdminEmailAttributes> getAdminEmails() {
        return adminEmails;
    }

    public void setAdminEmails(Map<String, AdminEmailAttributes> adminEmails) {
        this.adminEmails = adminEmails;
    }
}
