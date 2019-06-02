package it.aust.view;

import it.aust.Util.DbUtil;
import it.aust.Util.StringUtil;
import it.aust.dao.BookDao;
import it.aust.dao.BookTypeDao;
import it.aust.model.Book;
import it.aust.model.BookType;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;



public class BookManageInterFrm extends JInternalFrame {
	private JComboBox s_bookTypeJcb =null;
	private JComboBox bookTypeJcb =null;
	private JTextField s_bookNameTxt;
	private JTextField s_authorTxt;
	private JRadioButton manJrb =null;
	private JRadioButton femaleJrb =null;
	private JTextArea bookDescTxt = null;
	
	private DbUtil dbUtil = new DbUtil();
	private BookTypeDao bookTypeDao = new BookTypeDao();
	private BookDao bookDao = new BookDao();
	private JTable bookTable;
	private JTextField idTxt;
	private JTextField bookNameTxt;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField priceTxt;
	private JTextField authorTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookManageInterFrm frame = new BookManageInterFrm();
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
	public BookManageInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u56FE\u4E66\u7BA1\u7406");
		setBounds(100, 100, 817, 697);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u641C\u7D22\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JScrollPane scrollPane = new JScrollPane();
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(46)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 711, Short.MAX_VALUE)
							.addComponent(scrollPane, Alignment.LEADING)))
					.addContainerGap(44, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(38, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel = new JLabel("\u7F16\u53F7\uFF1A");
		
		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setColumns(10);
		
		JLabel label_3 = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		
		bookNameTxt = new JTextField();
		bookNameTxt.setColumns(10);
		
		JLabel label_4 = new JLabel("\u4F5C\u8005\u6027\u522B\uFF1A");
		
		manJrb = new JRadioButton("\u7537");
		manJrb.setSelected(true);
		buttonGroup.add(manJrb);
		
		femaleJrb = new JRadioButton("\u5973");
		buttonGroup.add(femaleJrb);
		
		JLabel label_5 = new JLabel("\u4EF7\u683C\uFF1A");
		
		priceTxt = new JTextField();
		priceTxt.setColumns(10);
		
		JLabel label_6 = new JLabel("\u56FE\u4E66\u4F5C\u8005\uFF1A");
		
		authorTxt = new JTextField();
		authorTxt.setColumns(10);
		
		JLabel label_7 = new JLabel("\u56FE\u4E66\u7C7B\u522B\uFF1A");
		
		bookTypeJcb = new JComboBox();
		
		JLabel lblNewLabel_1 = new JLabel("\u56FE\u4E66\u63CF\u8FF0\uFF1A");
		
		bookDescTxt = new JTextArea();
		
		JButton btnNewButton = new JButton("\u4FEE\u6539");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookUpdateActionPerformed(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(BookManageInterFrm.class.getResource("/images/modify.png")));
		
		JButton btnNewButton_1 = new JButton("\u5220\u9664");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookDeleteActionPerformed(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(BookManageInterFrm.class.getResource("/images/delete.png")));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(29)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(btnNewButton)
							.addGap(34)
							.addComponent(btnNewButton_1))
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
							.addComponent(lblNewLabel_1)
							.addGroup(gl_panel_1.createSequentialGroup()
								.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
									.addGroup(gl_panel_1.createSequentialGroup()
										.addComponent(label_5)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(priceTxt))
									.addGroup(gl_panel_1.createSequentialGroup()
										.addComponent(lblNewLabel)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGap(38)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
									.addGroup(gl_panel_1.createSequentialGroup()
										.addComponent(label_3)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_panel_1.createSequentialGroup()
										.addComponent(label_6)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(authorTxt)))
								.addGap(32)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
									.addComponent(label_4)
									.addComponent(label_7))
								.addGap(18)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
									.addGroup(gl_panel_1.createSequentialGroup()
										.addComponent(manJrb)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(femaleJrb))
									.addComponent(bookTypeJcb, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)))
							.addComponent(bookDescTxt, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 483, GroupLayout.PREFERRED_SIZE)))
					.addGap(107))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3)
						.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4)
						.addComponent(manJrb)
						.addComponent(femaleJrb))
					.addGap(30)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_5)
						.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_6)
						.addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_7)
						.addComponent(bookTypeJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1)
						.addComponent(bookDescTxt, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		bookTable = new JTable();
		bookTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				bookTableMousePressed(e);
			}
		});
		bookTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u56FE\u4E66\u540D\u79F0", "\u56FE\u4E66\u4F5C\u8005", "\u4F5C\u8005\u6027\u522B", "\u56FE\u4E66\u4EF7\u683C", "\u56FE\u4E66\u63CF\u8FF0", "\u56FE\u4E66\u7C7B\u522B"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		bookTable.getColumnModel().getColumn(5).setPreferredWidth(151);
		scrollPane.setViewportView(bookTable);
		
		JLabel label = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		
		s_bookNameTxt = new JTextField();
		s_bookNameTxt.setColumns(10);
		
		JLabel label_1 = new JLabel("\u56FE\u4E66\u4F5C\u8005\uFF1A");
		
		s_authorTxt = new JTextField();
		s_authorTxt.setColumns(10);
		
		JLabel label_2 = new JLabel("\u56FE\u4E66\u7C7B\u522B\uFF1A");
		
		s_bookTypeJcb = new JComboBox();
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookSearchActionPerformed(e);
			}

			
		});
		button.setIcon(new ImageIcon(BookManageInterFrm.class.getResource("/images/search.png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(19)
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(s_bookNameTxt, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(label_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(s_authorTxt, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addComponent(label_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(s_bookTypeJcb, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
					.addComponent(button)
					.addGap(24))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(s_bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(s_authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2)
						.addComponent(s_bookTypeJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button))
					.addContainerGap(42, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);

		bookDescTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185), 1, false));
		
		this.fillBookType("search");
		this.fillBookType("modify");
		this.fillTable(new Book());
	}
	
	/**
	 * ͼ��ɾ���¼�����
	 * @param e
	 */
	private void bookDeleteActionPerformed(ActionEvent evt) {
		String id = this.idTxt.getText();
		if (StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "��ѡ��Ҫɾ���ļ�¼��");
			return;
		}
		int n = JOptionPane.showConfirmDialog(null, "ȷ��Ҫɾ��������¼��");
		if (n == 0) {
			Connection con = null;
			try {
				con = dbUtil.getCon();
				int deleteNum = bookDao.delete(con, id);
				if (deleteNum == 1) {
					JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
					this.resetValue();
					this.fillTable(new Book());
				} else {
					JOptionPane.showMessageDialog(null, "ɾ��ʧ��");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "ɾ��ʧ��");
			} finally {
				try {
					dbUtil.close(con);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * ͼ���޸��¼�����
	 * @param e
	 */
	private void bookUpdateActionPerformed(ActionEvent evt) {
		String id = this.idTxt.getText();
		if (StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "��ѡ��Ҫ�޸ĵļ�¼��");
			return;
		}
		
		String bookName=this.bookNameTxt.getText();
		String author=this.authorTxt.getText();
		String price=this.priceTxt.getText();
		String bookDesc=this.bookDescTxt.getText();
		
		if(StringUtil.isEmpty(bookName)){
			JOptionPane.showMessageDialog(null, "ͼ�����Ʋ���Ϊ�գ�");
			return;
		}
		if(StringUtil.isEmpty(author)){
			JOptionPane.showMessageDialog(null, "ͼ�����߲���Ϊ�գ�");
			return;
		}
		if(StringUtil.isEmpty(price)){
			JOptionPane.showMessageDialog(null, "ͼ��۸���Ϊ�գ�");
			return;
		}
		
		
		String sex="";
		if(this.manJrb.isSelected()){
			sex="��";
		}else if(this.femaleJrb.isSelected()){
			sex="Ů";
		}
		
		BookType bookType=(BookType) this.bookTypeJcb.getSelectedItem();
		int bookTypeId=bookType.getId();
		
		Book book=new Book(Integer.parseInt(id),bookName,author,sex,Float.parseFloat(price), bookDesc, bookTypeId);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int modifyNum = bookDao.update(con, book);
			if (modifyNum == 1) {
				JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
				this.resetValue();
				this.fillTable(new Book());
			} else {
				JOptionPane.showMessageDialog(null, "�޸�ʧ��");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "�޸�ʧ��");
		} finally {
			try {
				dbUtil.close(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * ����е���¼�����
	 * @param evt
	 */
	private void bookTableMousePressed(MouseEvent evt) {
		// ��ȡѡ�е���
		int row = this.bookTable.getSelectedRow();
		this.idTxt.setText((Integer) bookTable.getValueAt(row, 0) + "");
		this.bookNameTxt.setText((String) bookTable.getValueAt(row, 1));
		this.authorTxt.setText((String) bookTable.getValueAt(row, 2));
		String sex = (String) bookTable.getValueAt(row, 3);
		if ("��".equals(sex)) {
			this.manJrb.setSelected(true);
		} else if ("Ů".equals(sex)) {
			this.femaleJrb.setSelected(true);
		}
		this.priceTxt.setText((Float) bookTable.getValueAt(row, 4) + "");
		this.bookDescTxt.setText((String) bookTable.getValueAt(row, 5));
		String bookTypeName = (String) bookTable.getValueAt(row, 6);
		int n = this.bookTypeJcb.getItemCount();
		for (int i = 0; i < n; i++) {
			BookType item = (BookType) this.bookTypeJcb.getItemAt(i);
			if (item.getBookTypeName().equals(bookTypeName)) {
				this.bookTypeJcb.setSelectedIndex(i);
			}
		}
	}

	/**
	 * ��ʼ��������
	 * @param type ����������
	 */
	private void fillBookType(String type) {
		Connection con = null;
		BookType bookType = null;
		try {
			con = dbUtil.getCon();
			ResultSet rs = bookTypeDao.list(con, new BookType());
			if ("search".equals(type)) {
				bookType = new BookType();
				bookType.setBookTypeName("��ѡ��...");
				bookType.setId(-1);
				this.s_bookTypeJcb.addItem(bookType);
			}
			while (rs.next()) {
				bookType = new BookType();
				bookType.setId(rs.getInt("id"));
				bookType.setBookTypeName(rs.getString("bookTypeName"));
				if ("search".equals(type)) {
					this.s_bookTypeJcb.addItem(bookType);
				} else if ("modify".equals(type)) {
					this.bookTypeJcb.addItem(bookType);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				dbUtil.close(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * ��ʼ���������
	 * @param book
	 */
	private void fillTable(Book book) {
		DefaultTableModel dtm = (DefaultTableModel) bookTable.getModel();
		dtm.setRowCount(0);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			ResultSet rs = bookDao.list(con, book);
			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getInt("id"));
				v.add(rs.getString("bookName"));
				v.add(rs.getString("author"));
				v.add(rs.getString("sex"));
				v.add(rs.getFloat("price"));
				v.add(rs.getString("bookDesc"));
				v.add(rs.getString("bookTypeName"));
				dtm.addRow(v);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				dbUtil.close(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * ͼ���ѯ�¼�������
	 * @param evt
	 */
	private void bookSearchActionPerformed(ActionEvent evt) {
		String bookName = this.s_bookNameTxt.getText();
		String author = this.s_authorTxt.getText();
		BookType bookType = (BookType) this.s_bookTypeJcb.getSelectedItem();
		int bookTypeId = bookType.getId();

		Book book = new Book(bookName, author, bookTypeId);

		this.fillTable(book);
		this.resetValue();
	}
	
	/**
	 * ���ñ�
	 */
	private void resetValue() {
		this.idTxt.setText("");
		this.bookNameTxt.setText("");
		this.authorTxt.setText("");
		this.manJrb.setSelected(true);
		this.priceTxt.setText("");
		this.bookDescTxt.setText("");
		if (this.bookTypeJcb.getItemCount() > 0) {
			this.bookTypeJcb.setSelectedIndex(0);
		}
	}
}
