package des;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyFrame extends JFrame {
	public static String groundresult;

	/*
	 * ����
	 */
	public MyFrame() {
		// TODO Auto-generated constructor stub
		luanch();
	}

	public static void main(String[] args) {
		new MyFrame().luanch();
	}

	JTextField mingwenfield = new JTextField(460);
	JTextField keyfield = new JTextField(460);
	JTextField result = new JTextField(460);
	// JTextArea area = new JTextArea(6,46);
	JLabel content_label = new JLabel("��������/�����ļ���·����");
	JLabel key_label = new JLabel("��������Կ�ļ���·����");
	JLabel result_label = new JLabel("                      ������Ϊ:");
	JLabel process_label = new JLabel("                                 ���̣�");
	JButton button = new JButton("����");
	JButton button2 = new JButton("����");
	JTextArea textArea = new JTextArea();
	JScrollPane scroll = new JScrollPane(textArea);
	JLabel keduchi1 = new JLabel("����֧�����ⳤ����ĸ�������");
	JLabel keduchi2 = new JLabel("��Կ֧�����ⳤ����ĸ�������");
	JPanel panel = new JPanel(null);

	public void luanch() {

                /*
	         * ���ܲ�����ť������
	         */
		button.addActionListener(new ActionListener() {

			@SuppressWarnings("resource")
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				descore descore = new descore();
				util util = new util();

				// ���ĳ�ʼ��������ÿһλתΪһ��64bit���ȵ�string
				groundresult += "=====  === == ==  = =   ��ʼ����   ===============\n";
				groundresult += "\n��ȡ������Ϊ:\n"
						+ descore.readTxt(mingwenfield.getText());
				groundresult += "\n��ȡ������Ϊ:\n"
						+ descore.readTxt(keyfield.getText());

				String[] mingwen = util.all2string(descore.readTxt(mingwenfield
						.getText()));

				String key = descore.readTxt(keyfield.getText());

				/**
				 * �������ʽ����Կ��ȡhashֵ����ʽ��Ϊchar[64]
				 * 
				 * @param k
				 * @return
				 */
				char[] K = util.keypre(key);
				// ���ܺ��ȡ����
				String mimi = descore.en(mingwen, K);
				String filePath = "d://��Ϣ��ȫ����/miwen.txt";
				descore.fileChaseFW(filePath, mimi);

				/*
				 * //�Ѽ����ļ�ת���ɶ������ļ� String demimi =
				 * descore.de(util.all222string(mimi), K);
				 */
				// ���ܽ����ʮ���������
				result.setText(mimi);
				result_label.setText("                      ������Ϊ:");
				textArea.setText(descore.groundresult);
				descore.groundresult = "";

			}

		});

                 /*
	          * ���ܲ�����ť������
	          */
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				descore descore = new descore();
				util util = new util();
				String mimi = descore.readTxt(mingwenfield.getText());
				String key = descore.readTxt(keyfield.getText());

				char[] K = util.keypre(key);
				// ���ܺ��ȡ����
				String demimi = descore.de(util.all222string(mimi), K);

				groundresult += "=====  === == ==  = =   ��ʼ����   ===============\n";
				groundresult += "\n��ȡ������Ϊ:\n"
						+ descore.readTxt(mingwenfield.getText());
				groundresult += "\n��ȡ����ԿΪ:\n"
						+ descore.readTxt(keyfield.getText());
				// �����ܺ������д��Ӳ����
				String filePath = "d://��Ϣ��ȫ����/mingwen2.txt";
				descore.fileChaseFW(filePath, demimi);
				String demimistring = util.byte2string(demimi);
				// System.out.println("2�����"+demimistring);
				// ���ܽ����ʮ���������

				result.setText(demimi);
				result_label.setText("                      ������Ϊ:");
				textArea.setText(descore.groundresult);
				descore.groundresult = "";
			}
		});
        //���ø�����Ĵ�С
		textArea.setLineWrap(true);
		content_label.setBounds(30, 20, 200, 30);
		mingwenfield.setBounds(180, 20, 500, 30);
		key_label.setBounds(30, 70, 200, 30);
		keyfield.setBounds(180, 70, 500, 30);
		result_label.setBounds(30, 120, 200, 30);
		result.setBounds(180, 120, 500, 30);
		process_label.setBounds(30, 300, 200, 30);
		button.setBounds(700, 200, 70, 30);
		button2.setBounds(700, 250, 70, 30);
		keduchi1.setBounds(180, 0, 200, 30);
		keduchi2.setBounds(180, 50, 200, 30);
		this.setTitle("DES�ӽ���");
		scroll.setBounds(180, 160, 500, 400);

		//�����ӵ������
		panel.add(keduchi1);
		panel.add(keduchi2);
		panel.add(content_label);
		panel.add(mingwenfield);
		panel.add(key_label);
		panel.add(keyfield);
		panel.add(result_label);
		panel.add(result);
		panel.add(process_label);
		panel.add(button2);
		panel.add(scroll);
		panel.add(button);
		this.add(panel);
		this.setBounds(300, 50, 800, 700);
		this.setVisible(true);

	}

}
