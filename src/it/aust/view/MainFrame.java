package it.aust.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JDesktopPane table =null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setTitle("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF\u4E3B\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u57FA\u672C\u6570\u636E\u7EF4\u62A4");
		mnNewMenu.setIcon(new ImageIcon(MainFrame.class.getResource("/images/base.png")));
		menuBar.add(mnNewMenu);
		
		JMenu menu = new JMenu("\u56FE\u4E66\u7C7B\u522B\u7BA1\u7406");
		menu.setIcon(new ImageIcon(MainFrame.class.getResource("/images/bookTypeManager.png")));
		mnNewMenu.add(menu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u56FE\u4E66\u7C7B\u522B\u6DFB\u52A0");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookTypeIFrame bookTypeIframe = new BookTypeIFrame(); 
				bookTypeIframe.setVisible(true);
				table.add(bookTypeIframe);
			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon(MainFrame.class.getResource("/images/add.png")));
		menu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u56FE\u4E66\u7C7B\u522B\u7EF4\u62A4");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookTypeManagerIFrame bookTypeManagerIframe = new BookTypeManagerIFrame(); 
				bookTypeManagerIframe.setVisible(true);
				table.add(bookTypeManagerIframe);
			}
		});
		mntmNewMenuItem_1.setIcon(new ImageIcon(MainFrame.class.getResource("/images/edit.png")));
		menu.add(mntmNewMenuItem_1);
		
		JMenu menu_1 = new JMenu("\u56FE\u4E66\u7BA1\u7406");
		menu_1.setIcon(new ImageIcon(MainFrame.class.getResource("/images/bookManager.png")));
		mnNewMenu.add(menu_1);
		
		JMenuItem menuItem_2 = new JMenuItem("\u56FE\u4E66\u6DFB\u52A0");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookAddInterFrame bookAddInterFrame = new BookAddInterFrame(); 
				bookAddInterFrame.setVisible(true);
				table.add(bookAddInterFrame);
			}
		});
		menuItem_2.setIcon(new ImageIcon(MainFrame.class.getResource("/images/add.png")));
		menu_1.add(menuItem_2);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u56FE\u4E66\u7EF4\u62A4");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookManageInterFrm bookAddInterFrame = new BookManageInterFrm(); 
				bookAddInterFrame.setVisible(true);
				table.add(bookAddInterFrame);
			}
		});
		mntmNewMenuItem_2.setIcon(new ImageIcon(MainFrame.class.getResource("/images/edit.png")));
		menu_1.add(mntmNewMenuItem_2);
		
		JMenuItem menuItem_1 = new JMenuItem("\u5B89\u5168\u9000\u51FA");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "是否退出系统?");
				if(result == 0){
					dispose();
				}
			}
		});
		menuItem_1.setIcon(new ImageIcon(MainFrame.class.getResource("/images/exit.png")));
		mnNewMenu.add(menuItem_1);
		
		JMenu menu_3 = new JMenu("\u5173\u4E8E\u4F5C\u8005");
		menu_3.setIcon(new ImageIcon(MainFrame.class.getResource("/images/about.png")));
		menuBar.add(menu_3);
		
		JMenuItem menuItem = new JMenuItem("\u4F5C\u8005\u8BE6\u60C5");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InternalFrame internalframe = new InternalFrame(); 
				internalframe.setVisible(true);
				table.add(internalframe);
			}
		});
		menuItem.setIcon(new ImageIcon(MainFrame.class.getResource("/images/about.png")));
		menu_3.add(menuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		table = new JDesktopPane();
		table.setBackground(Color.WHITE);
		contentPane.add(table, BorderLayout.CENTER);
		
		//设置主界面最大化
		this.setExtendedState(MainFrame.MAXIMIZED_BOTH);
	}
}
