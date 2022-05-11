package org.apache.ibatis.jdbc;


import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.io.PrintWriter;

public class ScriptRunnerProduct {
	public void printResults(Statement statement, boolean hasResults, ScriptRunner scriptRunner,
			PrintWriter thisLogWriter) {
		if (!hasResults) {
			return;
		}
		try (ResultSet rs = statement.getResultSet()) {
			ResultSetMetaData md = rs.getMetaData();
			int cols = md.getColumnCount();
			for (int i = 0; i < cols; i++) {
				String name = md.getColumnLabel(i + 1);
				print(name + "\t", thisLogWriter);
			}
			println("", thisLogWriter);
			while (rs.next()) {
				for (int i = 0; i < cols; i++) {
					String value = rs.getString(i + 1);
					print(value + "\t", thisLogWriter);
				}
				println("", thisLogWriter);
			}
		} catch (SQLException e) {
			scriptRunner.printlnError("Error printing results: " + e.getMessage());
		}
	}

	public void print(Object o, PrintWriter thisLogWriter) {
		if (thisLogWriter != null) {
			thisLogWriter.print(o);
			thisLogWriter.flush();
		}
	}

	public void println(Object o, PrintWriter thisLogWriter) {
		if (thisLogWriter != null) {
			thisLogWriter.println(o);
			thisLogWriter.flush();
		}
	}
}