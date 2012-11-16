package org.dbunit.database;

import org.hsqldb.Server;

public class HsqlServer {
	 private void startHsqlServer(String dbPath, String dbName, int port) {   
	        Server server = new Server();   
	        // 0��ʾ��0�����ݿ⣬Serverģʽ��������10�����ݿ�   
	        server.setDatabasePath(0, dbPath + dbName);   
	        server.setDatabaseName(0, dbName);   
	        server.setPort(port);   
	        server.setSilent(true);   
	        server.start();   
	        System.out.println("HSQLDB Server started!");   
	    }   
	    public static void main(String[] args) {   
	        // Դ����·��   
	        System.out.println(System.getProperty("user.dir"));   
	        // ��·��   
	    System.out.println(Thread.currentThread().getContextClassLoader()   
	                .getResource(".").getPath());   
	        String base = System.getProperty("user.dir");   
	        String dbPath = base   
	                + "\\data\\";   
	        String dbName = "sampledb2";   
	        int port = 2011;   
	        new HsqlServer().startHsqlServer(dbPath, dbName, port);   
	    }   

}
