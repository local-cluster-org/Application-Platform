package com.demo.vulnerable;

import org.springframework.web.bind.annotation.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    private Connection conn;

    @GetMapping("/search")
    public String search(@RequestParam String name) throws SQLException {
        Statement stmt = conn.createStatement();
        String query = "SELECT * FROM reports WHERE name = '" + name + "'";
        ResultSet rs = stmt.executeQuery(query);
        return rs.toString();
    }

    @GetMapping("/byOwner")
    public String byOwner(@RequestParam String owner) throws SQLException {
        Statement stmt = conn.createStatement();
        String query = "SELECT * FROM reports WHERE owner = '" + owner + "'";
        ResultSet rs = stmt.executeQuery(query);
        return rs.toString();
    }

    @GetMapping("/byDept")
    public String byDept(@RequestParam String dept) throws SQLException {
        Statement stmt = conn.createStatement();
        String query = "SELECT * FROM reports WHERE dept = '" + dept + "'";
        ResultSet rs = stmt.executeQuery(query);
        return rs.toString();
    }

    @GetMapping("/echo")
    public void echo(@RequestParam String msg, HttpServletResponse resp) throws IOException {
        resp.getWriter().println("<div>" + msg + "</div>");
    }

    @GetMapping("/echoTitle")
    public void echoTitle(@RequestParam String title, HttpServletResponse resp) throws IOException {
        resp.getWriter().println("<h1>" + title + "</h1>");
    }

    @GetMapping("/echoComment")
    public void echoComment(@RequestParam String comment, HttpServletResponse resp) throws IOException {
        resp.getWriter().println("<p>" + comment + "</p>");
    }

    @GetMapping("/file")
    public String file(@RequestParam String filename) throws IOException {
        File f = new File("/data/reports/" + filename);
        BufferedReader br = new BufferedReader(new FileReader(f));
        return br.readLine();
    }

    @GetMapping("/download")
    public String download(@RequestParam String path) throws IOException {
        File f = new File("/data/exports/" + path);
        BufferedReader br = new BufferedReader(new FileReader(f));
        return br.readLine();
    }
}
