package com.example.designpattern.structural;

/**
 * defines a higher-level interface that makes the subsystem easier to use
 */
public class Facade {
    public static void main(String[] args) {
        // get report without using Facade
        String connection = MysqlHelper.getMysqlConnection();
        MysqlHelper mysqlHelper = new MysqlHelper();
        mysqlHelper.generateHTMLReport("table1", connection);
        // get report using Facade
        DBReportHelper.generateReport(DBReportHelper.DBTypes.ORACLE, DBReportHelper.ReportTypes.PDF, "table2");
    }
}

class DBReportHelper {
    // Facade
    public static void generateReport(DBTypes dbType, ReportTypes reportType, String tableName) {
        String connecton = null;
        DBHelper dbHelper = null;
        switch (dbType) {
            case MYSQL:
                connecton = MysqlHelper.getMysqlConnection();
                dbHelper = new MysqlHelper();
                break;
            case ORACLE:
                connecton = OracleHelper.getOracleConnection();
                dbHelper = new OracleHelper();
                break;
        }
        generateReportWithHelper(reportType, tableName, dbHelper, connecton);
    }

    private static void generateReportWithHelper(ReportTypes reportType, String tableName, DBHelper dbHelper, String connection) {
        switch (reportType) {
            case PDF:
                dbHelper.generatePDFReport(tableName, connection);
                break;
            case HTML:
                dbHelper.generateHTMLReport(tableName, connection);
                break;
        }
    }

    public static enum DBTypes {
        MYSQL, ORACLE;
    }

    public static enum ReportTypes {
        HTML, PDF;
    }
}

abstract class DBHelper {
    abstract void generatePDFReport(String tableName, String con);
    abstract void generateHTMLReport(String tableName, String con);
}

class MysqlHelper extends DBHelper {
    public static String getMysqlConnection() {
        System.out.println("get mysql connection");
        return "mysql connection";
    }

    public void generatePDFReport(String tableName, String con) {
        System.out.println("generate mysql PDF report " + tableName + " with connection " + con);
    }

    public void generateHTMLReport(String tableName, String con) {
        System.out.println("generate mysql HTML report " + tableName + " with connection " + con);
    }
}

class OracleHelper extends DBHelper {
    public static String getOracleConnection() {
        System.out.println("get oracle connection");
        return "oracle connection";
    }

    public void generatePDFReport(String tableName, String con) {
        System.out.println("generate oracle PDF report " + tableName + " with connection " + con);
    }

    public void generateHTMLReport(String tableName, String con) {
        System.out.println("generate oracle HTML report " + tableName + " with connection " + con);
    }
}

