package it.aust.view;

import it.aust.Util.DbUtil;
import it.aust.Util.StringUtil;
import it.aust.dao.BookTypeDao;
import it.aust.model.BookType;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BookTypeManagerIFrame extends JInternalFrame {
	private JTable BookTypeTable;
	private BookTypeDao bookTypeDao = new BookTypeDao();
	private DbUtil dbUtil =new DbUtil();
	private JTextField bookTypeNameTxt;
	private JTextField idTxt;
	private JTextField bookTypeTxt;
	private	JTextArea bookTypeDescTxt;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookTypeManagerIFrame frame = new BookTypeManagerIFrame();
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
	public BookTypeManagerIFrame() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\u56FE\u4E66\u7C7B\u522B\u7BA1\u7406");
		setBounds(100, 100, 532, 583);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				bookTypeMousePressedAction(e);
			}
		});
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u7C7B\u522B\u540D\u79F0");
		
		bookTypeNameTxt = new JTextField();
		bookTypeNameTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookTypeNameSearchAction(e);
			}
		});
		
		btnNewButton.setIcon(new ImageIcon(BookTypeManagerIFrame.class.getResource("/images/search.png")));
		
		BookTypeTable = new JTable();
		BookTypeTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				bookTypeMousePressedAction(e);
			}
		});
		BookTypeTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u56FE\u4E66\u7C7B\u522B\u540D\u79F0", "\u56FE\u4E66\u7C7B\u522B\u63CF\u8FF0"
			}
		));
		BookTypeTable.getColumnModel().getColumn(1).setPreferredWidth(112);
		BookTypeTable.getColumnModel().getColumn(2).setPreferredWidth(130);
		scrollPane.setViewportView(BookTypeTable);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(74)
							.addComponent(lblNewLabel)
							.addGap(10)
							.addComponent(bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(btnNewButton))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(65)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 423, GroupLayout.PREFERRED_SIZE)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE))))
					.addContainerGap(28, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(5)
							.addComponent(lblNewLabel))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnNewButton))
					.addGap(36)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
					.addGap(43)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel label = new JLabel("\u7F16\u53F7\uFF1A");
		
		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setColumns(10);
		
		JLabel label_1 = new JLabel("\u56FE\u4E66\u7C7B\u522B\u540D\u79F0\uFF1A");
		
		bookTypeTxt = new JTextField();
		bookTypeTxt.setColumns(10);
		
		JLabel label_2 = new JLabel("\u63CF\u8FF0\uFF1A");
		
		bookTypeDescTxt = new JTextArea();
		
		JButton button = new JButton("\u4FEE\u6539");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonPressAction(e);
			}
		});
		button.setIcon(new ImageIcon(BookTypeManagerIFrame.class.getResource("/images/modify.png")));
		
		JButton button_1 = new JButton("\u5220\u9664");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookTypeDeletePeform(e);
			}
		});
		button_1.setIcon(new ImageIcon(BookTypeManagerIFrame.class.getResource("/images/delete.png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(26)
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(bookTypeTxt, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
									.addComponent(button)
									.addGap(51)
									.addComponent(button_1)
									.addGap(66))
								.addComponent(bookTypeDescTxt, GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE))))
					.addGap(30))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(bookTypeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(bookTypeDescTxt, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_1)
						.addComponent(button))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
		this.fillTable(new BookType());
		
		
	}
	
	private void bookTypeDeletePeform(ActionEvent event) {
		String id = idTxt.getText();
		if(StringUtil.isEmpty(id)){
			JOptionPane.showMessageDialog(null, "请选择要删除的记录");
		}
		int result = JOptionPane.showConfirmDialog(null, "确认删除信息吗？");
		if(result == 0){
			Connection con = null;
			try{
				con = dbUtil.getCon();
				int deleteNumber =bookTypeDao.delete(con,Integer.parseInt(id));
				if(deleteNumber ==1){
					JOptionPane.showMessageDialog(null, "删除成功");
					this.ResetValue();
					this.fillTable(new BookType());
				}else{
					JOptionPane.showMessageDialog(null, "删除失败");
				}
				
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				
			}
		}
	}

	/**
	 * 执行修改操作
	 * @param e
	 */
	
	private void buttonPressAction(ActionEvent event) {
		// TODO Auto-generated method stub
		String id = idTxt.getText();
		String bookTypeName = bookTypeTxt.getText();
		String bookTypeDesc = bookTypeDescTxt.getText();
		if(StringUtil.isEmpty(id)){
			JOptionPane.showInternalMessageDialog(null,"请选择要修改的数据");
			return;
		}
		BookType bookType = new BookType(Integer.parseInt(id),bookTypeName,bookTypeDesc);
		Connection con = null;
		try{
			 con = dbUtil.getCon();
			 int result = bookTypeDao.update(con, bookType);
			 if(result == 1){
				 JOptionPane.showMessageDialog(null,"修改成功");
				 this.ResetValue();
				 this.fillTable(new BookType());
			 }else{
				 JOptionPane.showMessageDialog(null,"修改失败");
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

	/**
	 * 点击表格执行事件
	 * @param e
	 */
	
	private void bookTypeMousePressedAction(MouseEvent e) {
		// TODO Auto-generated method stub
		int row =BookTypeTable.getSelectedRow();
		idTxt.setText(BookTypeTable.getValueAt(row, 0).toString());
		bookTypeTxt.setText((String)BookTypeTable.getValueAt(row,1));
		bookTypeDescTxt.setText((String)BookTypeTable.getValueAt(row, 2));
	}
	

	/**
	 * 图书类别搜索处理
	 * @param e
	 */

	private void bookTypeNameSearchAction(ActionEvent e) {
		// TODO Auto-generated method stub
		String s_bookTypeName = this.bookTypeNameTxt.getText();
		BookType bookType = new BookType();
		bookType.setBookTypeName(s_bookTypeName);
		this.fillTable(bookType);
	}

	/**
	 * 填充页面的表格
	 * @param bookType
	 */
	private void fillTable(BookType bookType){
		DefaultTableModel dtable =	(DefaultTableModel) BookTypeTable.getModel();
		dtable.setRowCount(0);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			ResultSet rs = bookTypeDao.list(con,bookType);
			while(rs.next()){
				Vector v = new Vector();
				v.add(rs.getInt("id"));
				v.add(rs.getString("bookTypeName"));
				v.add(rs.getString("bookTypeDesc"));
				dtable.addRow(v);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
	
	private void ResetValue(){
		this.bookTypeDescTxt.setText("");
		this.bookTypeNameTxt.setText("");
		this.idTxt.setText("");
	}
}
