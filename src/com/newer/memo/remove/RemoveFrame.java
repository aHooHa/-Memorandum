package com.newer.memo.remove;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.newer.memo.dao.Memo;
import com.newer.memo.dao.MemoDao;

import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class RemoveFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private List<Memo> list = new ArrayList<>();
	private int index = 0;

	public void run() {
		try {
			RemoveFrame frame = new RemoveFrame();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	public RemoveFrame() throws SQLException {

		list = new MemoDao().findAll();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel label = new JLabel("姓名");

		textField = new JTextField();
		textField.setColumns(10);

		JLabel label_1 = new JLabel("类型");

		textField_1 = new JTextField();
		textField_1.setColumns(10);

		JLabel label_2 = new JLabel("时间");

		textField_2 = new JTextField();
		textField_2.setColumns(10);

		JLabel label_3 = new JLabel("主题");

		textField_3 = new JTextField();
		textField_3.setColumns(10);

		JLabel label_4 = new JLabel("内容");

		JTextArea textArea = new JTextArea();
		JButton button = new JButton("上一条");
		JButton button_1 = new JButton("下一条");
		JButton button_2 = new JButton("删除");
		JButton button_3 = new JButton("返回");
		boolean tag = true;
		if (list.size() == 0) {
			
			JOptionPane.showMessageDialog(textArea, "没有备忘记录");
			tag = false;
			
		} 
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup().addComponent(label)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(label_1)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(label_2)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(textField_2,
										GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(label_3)
										.addComponent(label_4))
								.addPreferredGap(
										ComponentPlacement.UNRELATED)
								.addGroup(
										gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 286,
														Short.MAX_VALUE)
												.addComponent(textField_3)
												.addGroup(gl_contentPane.createSequentialGroup().addComponent(button)
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addComponent(button_1)
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addComponent(button_2)
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addComponent(button_3)))))
				.addContainerGap(62, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(label)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(label_1)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(label_2).addComponent(textField_2, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(33)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(label_3)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addGap(61).addComponent(label_4))
								.addGroup(gl_contentPane.createSequentialGroup().addGap(32).addComponent(textArea,
										GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(button)
								.addComponent(button_1).addComponent(button_2).addComponent(button_3))
						.addContainerGap(14, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
		
		if(tag){
			Memo m = list.get(index);
			textField.setText(m.getName());
			textField_1.setText(m.getType());
			textField_2.setText(m.getTime());
			textField_3.setText(m.getTheame());
			textArea.setText(m.getContext());
		
		
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				--index;
				if (index < 0) {
					index = 0;
					JOptionPane.showMessageDialog(textArea, "已经是第一条了");
				}
				Memo m = list.get(index);
				textField.setText(m.getName());
				textField_1.setText(m.getType());
				textField_2.setText(m.getTime());
				textField_3.setText(m.getTheame());
				textArea.setText(m.getContext());

			}
		});

		
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				++index;
				if (index > list.size() - 1) {

					if (list.size() == 0) {
						index = 0;
					} else {
						index = list.size() - 1;
					}
					JOptionPane.showMessageDialog(textArea, "已经是最后一条了");
				}
				Memo m = list.get(index);

				textField.setText(m.getName());
				textField_1.setText(m.getType());
				textField_2.setText(m.getTime());
				textField_3.setText(m.getTheame());
				textArea.setText(m.getContext());
			}
		});

		
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new MemoDao().removeMemo(list.get(index));
					list.remove(index);
					if (index != 0) {
						index--;
					}
					if (list.size() == 0) {
						textField.setText("");
						textField_1.setText("");
						textField_2.setText("");
						textField_3.setText("");
						textArea.setText("");
						JOptionPane.showMessageDialog(textArea, "备忘本为空");
						

					} else {

						JOptionPane.showMessageDialog(textArea, "删除成功");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
		
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
	}
}
