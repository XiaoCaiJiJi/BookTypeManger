package it.aust.view;

import it.aust.Util.DbUtil;
import it.aust.Util.StringUtil;
import it.aust.dao.BookTypeDao;
import it.aust.model.BookType;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

public class BookTypeIFrame extends JInternalFrame {
	private JTextField BookTypeNameTxt;
	private JTextArea BookTypeDescTxt;
	private BookTypeDao bookTypeDao = new BookTypeDao();
	private DbUtil dbUtil =new DbUtil();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookTypeIFrame frame = new BookTypeIFrame();
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
	public BookTypeIFrame() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\u56FE\u4E66\u7C7B\u522B\u6DFB\u52A0");
		setBounds(100, 100, 450, 300);
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u7C7B\u522B\u540D\u79F0\uFF1A");
		
		JLabel lblNewLabel_1 = new JLabel("\u56FE\u4E66\u7C7B\u522B\u63CF\u8FF0\uFF1A");
		
		BookTypeNameTxt = new JTextField();
		BookTypeNameTxt.setColumns(10);
		
		BookTypeDescTxt = new JTextArea();
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					bookTypeAddActionPerform(e);
				}
		});
		btnNewButton.setIcon(new ImageIcon(BookTypeIFrame.class.getResource("/images/add.png")));
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValuePeform(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(BookTypeIFrame.class.getResource("/images/reset.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(89)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(BookTypeDescTxt, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(BookTypeNameTxt)))
					.addContainerGap(42, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(135)
					.addComponent(btnNewButton)
					.addGap(34)
					.addComponent(btnNewButton_1)
					.addContainerGap(79, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(72)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(BookTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(BookTypeDescTxt, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap(50, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		BookTypeDescTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185),1,false));
	}

	private void bookTypeAddActionPerform(ActionEvent event) {
		String bookTypeName = this.BookTypeNameTxt.getText();
		String bookTypeDesc = this.BookTypeDescTxt.getText();
		if(StringUtil.isEmpty(bookTypeName)){
			JOptionPane.showMessageDialog(null, "图书类别名称不能为空！");
			return;
		}		
		BookType bookType = new BookType(bookTypeName,bookTypeDesc);
		Connection con = null;
		try{
			con = dbUtil.getCon();
			int result =BookTypeDao.add(con, bookType);
			if(result ==1){
				JOptionPane.showMessageDialog(null, "添加成功");
				resetValue();
			}else{
				JOptionPane.showMessageDialog(null,"添加失败");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				dbUtil.close(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void resetValuePeform(ActionEvent e) {
		this.resetValue();
	}
	
	private void resetValue(){
		this.BookTypeNameTxt.setText("");
		this.BookTypeDescTxt.setText("");
	}
	
}
