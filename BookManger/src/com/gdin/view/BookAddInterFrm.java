/*
 * BookAddInterFrm.java
 *
 * Created on __DATE__, __TIME__
 */

package com.gdin.view;

import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import com.gdin.dao.BookDao;
import com.gdin.dao.BookTypeDao;
import com.gdin.model.Book;
import com.gdin.model.BookType;
import com.gdin.util.DbUtil;
import com.gdin.util.StringUtil;

/**
 *
 * @author  __USER__
 */
public class BookAddInterFrm extends javax.swing.JInternalFrame {
	DbUtil dbUtil = new DbUtil();
	BookTypeDao bookTypeDao = new BookTypeDao();
	BookDao bookDao = new BookDao();

	/** Creates new form BookAddInterFrm */
	public BookAddInterFrm() {
		initComponents();
		this.setLocation(200, 50);
		this.fillBookType();
		this.jrb_man.setSelected(true);
		this.jcb_BookType.setSelectedIndex(0);
	}

	/*
	 * ���������
	 */
	private void fillBookType() {
		Connection con = null;
		BookType bookType = null;
		try {
			con = dbUtil.getCon();
			ResultSet rs = bookTypeDao.bookTypeList(con, new BookType());
			while (rs.next()) {
				bookType = new BookType();
				bookType.setId(rs.getInt("id"));
				bookType.setBookTypeName(rs.getString("bookTypeName"));
				this.jcb_BookType.addItem(bookType);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

buttonGroup1 = new javax.swing.ButtonGroup();
jLabel1 = new javax.swing.JLabel();
bookNameTxt = new javax.swing.JTextField();
jLabel2 = new javax.swing.JLabel();
authorTxt = new javax.swing.JTextField();
jLabel3 = new javax.swing.JLabel();
jrb_man = new javax.swing.JRadioButton();
jrb_female = new javax.swing.JRadioButton();
jLabel4 = new javax.swing.JLabel();
priceTxt = new javax.swing.JTextField();
jLabel5 = new javax.swing.JLabel();
jcb_BookType = new javax.swing.JComboBox();
jLabel6 = new javax.swing.JLabel();
jScrollPane1 = new javax.swing.JScrollPane();
bookDescTxt = new javax.swing.JTextArea();
jButton1 = new javax.swing.JButton();
jButton2 = new javax.swing.JButton();

setClosable(true);
setIconifiable(true);
setTitle("\u56fe\u4e66\u6dfb\u52a0");

jLabel1.setText("\u56fe\u4e66\u540d\u79f0\uff1a");

jLabel2.setText("\u56fe\u4e66\u4f5c\u8005\uff1a");

jLabel3.setText("\u4f5c\u8005\u6027\u522b\uff1a");

/*jrb_man.setText("\u7537");

jrb_female.setText("\u5973");*/
buttonGroup1.add(jrb_man);
jrb_man.setText("\u7537");
jrb_man.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
	jrb_manActionPerformed(evt);
}
});

buttonGroup1.add(jrb_female);
jrb_female.setText("\u5973");

jLabel4.setText("\u56fe\u4e66\u4ef7\u683c\uff1a");

jLabel5.setText("\u56fe\u4e66\u7c7b\u522b\uff1a");

jLabel6.setText("\u56fe\u4e66\u63cf\u8ff0\uff1a");

bookDescTxt.setColumns(20);
bookDescTxt.setRows(5);
jScrollPane1.setViewportView(bookDescTxt);

jButton1.setIcon(new javax.swing.ImageIcon("F:\\myeclipse project\\BookManger\\images\\add.png")); // NOI18N
jButton1.setText("\u6dfb\u52a0");
jButton1.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
jButton1ActionPerformed(evt);
}
});

jButton2.setIcon(new javax.swing.ImageIcon("F:\\myeclipse project\\BookManger\\images\\reset.png")); // NOI18N
jButton2.setText("\u91cd\u7f6e");
jButton2.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
jButton2ActionPerformed(evt);
}
});

javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
getContentPane().setLayout(layout);
layout.setHorizontalGroup(
layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(layout.createSequentialGroup()
.addGap(55, 55, 55)
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(layout.createSequentialGroup()
.addComponent(jButton1)
.addGap(57, 57, 57)
.addComponent(jButton2)
.addGap(331, 331, 331))
.addGroup(layout.createSequentialGroup()
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addComponent(jLabel1)
.addComponent(jLabel3)
.addComponent(jLabel5)
.addComponent(jLabel6))
.addGap(29, 29, 29)
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(layout.createSequentialGroup()
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
.addComponent(jcb_BookType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
.addGroup(layout.createSequentialGroup()
.addComponent(jrb_man, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
.addComponent(jrb_female, 0, 0, Short.MAX_VALUE))
.addComponent(bookNameTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
.addGap(63, 63, 63)
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addComponent(jLabel2)
.addComponent(jLabel4))
.addGap(33, 33, 33)
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
.addComponent(priceTxt)
.addComponent(authorTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)))
.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE))
.addContainerGap(32, Short.MAX_VALUE))))
);
layout.setVerticalGroup(
layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(layout.createSequentialGroup()
.addGap(32, 32, 32)
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
.addComponent(jLabel1)
.addComponent(bookNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
.addComponent(jLabel2)
.addComponent(authorTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
.addGap(35, 35, 35)
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
.addComponent(jLabel3)
.addComponent(jrb_man)
.addComponent(jrb_female)
.addComponent(jLabel4)
.addComponent(priceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
.addGap(46, 46, 46)
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
.addComponent(jLabel5)
.addComponent(jcb_BookType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
.addGap(43, 43, 43)
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addComponent(jLabel6)
.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
.addComponent(jButton1)
.addComponent(jButton2))
.addGap(26, 26, 26))
);

pack();
}// </editor-fold>

	private void jrb_manActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}
	
	//GEN-END:initComponents
	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		String bookName = this.bookNameTxt.getText();
		String author = this.authorTxt.getText();
		String price = this.priceTxt.getText();
		String bookDesc = this.bookDescTxt.getText();

		if (StringUtil.isEmpty(bookName)) {
			JOptionPane.showMessageDialog(null, "ͼ�����Ʋ���Ϊ�գ�");
			return;
		}
		if (StringUtil.isEmpty(author)) {
			JOptionPane.showMessageDialog(null, "ͼ�����߲���Ϊ�գ�");
			return;
		}
		if (StringUtil.isEmpty(price)) {
			JOptionPane.showMessageDialog(null, "ͼ��۸���Ϊ�գ�");
			return;
		}

		String sex = "";
		if (this.jrb_man.isSelected()) {
			sex = "��";
		} else if (this.jrb_female.isSelected()) {
			sex = "Ů";
		}

		BookType bookType = (BookType) this.jcb_BookType.getSelectedItem();
		int bookTypeId = bookType.getId();

		Book book = new Book(bookName, author, sex, Float.parseFloat(price),
				bookDesc, bookTypeId);

		Connection con = null;
		try {
			con = dbUtil.getCon();
			int addNum = bookDao.bookAdd(con, book);
			if (addNum == 1) {
				JOptionPane.showMessageDialog(null, "ͼ�����ӳɹ���");
				this.resetValue();
			} else {
				JOptionPane.showMessageDialog(null, "ͼ������ʧ�ܣ�");
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "ͼ������ʧ�ܣ�");
		} finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void resetValue() {
		this.bookNameTxt.setText("");
		this.authorTxt.setText("");
		this.jrb_man.setSelected(true);
		this.priceTxt.setText("");
		this.jcb_BookType.setSelectedIndex(0);
		this.bookDescTxt.setText("");
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		this.resetValue();
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JTextField authorTxt;
	private javax.swing.JTextArea bookDescTxt;
	private javax.swing.JTextField bookNameTxt;
	private javax.swing.ButtonGroup buttonGroup1;
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JComboBox jcb_BookType;
	private javax.swing.JRadioButton jrb_female;
	private javax.swing.JRadioButton jrb_man;
	private javax.swing.JTextField priceTxt;
	// End of variables declaration//GEN-END:variables

}