package com.maipu.uti;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import oracle.jdbc.OracleDriver;

public class ConnOracle {
	static public Connection getcon(){
		Scanner input = new Scanner(System.in);
		Connection conn = null;
		String username = null;
		String password = null;
		String oracle_url = "jdbc:oracle:thin:@localhost:1521:orcl";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		while(conn == null){
			System.out.println("��ʼ�������ݿ�");
			username = JOptionPane.showInputDialog("�������û���");
			if(username == null)
				System.exit(0);
			//System.out.print("�������û���:");
			//username = input.next();
			//System.out.print("����������:");
			//password = input.next();
			password = JOptionPane.showInputDialog("����������");
			if(password == null)
				System.exit(0);
			try {
				conn = DriverManager.getConnection(oracle_url, username, password);
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			if(conn == null)
				//System.out.println("���ݿ�����ʧ��");
				JOptionPane.showMessageDialog(null, "�˺Ż��������", "����", JOptionPane.PLAIN_MESSAGE);
			else
				//System.out.println("���ݿ����ӳɹ�");
				JOptionPane.showMessageDialog(null, "���ݿ����ӳɹ�", "��ϲ", JOptionPane.PLAIN_MESSAGE);
		}
		return conn;
	}
	
	static public void closeCon(Connection con){
		if(con != null){
			try {
				con.close();
				System.out.println("���ݿ������ѹرգ�");
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		ConnOracle.closeCon(ConnOracle.getcon());
	}
}
