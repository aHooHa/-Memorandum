package com.newer.memo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;

import com.newer.memo.change.ChangeMemo;
import com.newer.memo.remove.RemoveFrame;
import com.newer.memo.reserch.ReserchFrame;
import com.newer.memo.write.WriteFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MemoFrame extends JFrame {

	/**
	 * Launch the application.
	 */
	static MemoFrame frame;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new MemoFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MemoFrame() {
		setTitle("备忘本");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JTextArea textArea = new JTextArea();
		textArea.setText("有了我，主人再也不用担心忘记事了！！");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(94)
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(102, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(84)
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(133, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u5DE5\u5177");
		menuBar.add(mnNewMenu);
		
		/**
		 * 实现写备忘事件功能
		 */
		JMenuItem menuItem = new JMenuItem("\u5199\u5907\u6CE8");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				new WriteFrame().run();
				
			}
		});
		mnNewMenu.add(menuItem);
		
		/**
		 * 实现修改功能
		 */
		JMenuItem menuItem_1 = new JMenuItem("\u4FEE\u6539\u5907\u6CE8");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ChangeMemo().run();
			}
		});
		mnNewMenu.add(menuItem_1);
		
		/**
		 * 实现删除功能
		 */
		JMenuItem menuItem_2 = new JMenuItem("\u5220\u9664\u5907\u6CE8");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RemoveFrame().run();
			}
		});
		mnNewMenu.add(menuItem_2);
		
		/**
		 * 实现查询功能
		 */
		JMenuItem menuItem_3 = new JMenuItem("\u67E5\u8BE2\u5907\u6CE8");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ReserchFrame().run();
			}
		});
		mnNewMenu.add(menuItem_3);
	}
}
