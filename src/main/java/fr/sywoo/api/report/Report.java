package fr.sywoo.api.report;

import java.util.Date;
import java.util.UUID;

public class Report {

    private String reason;
    private ReportType reportType;
    private UUID reporter;
    private String serverName;
    private Date date;

    public Report(String reason, ReportType reportType, UUID reporter, String serverName) {
        this.reason = reason;
        this.reportType = reportType;
        this.reporter = reporter;
        this.serverName = serverName;
        this.date = new Date();
    }

    public String getReason() {
        return reason;
    }

    public ReportType getReportType() {
        return reportType;
    }

    public UUID getReporter() {
        return reporter;
    }

    public String getServerName() {
        return serverName;
    }

    public Date getDate() {
        return date;
    }
}
