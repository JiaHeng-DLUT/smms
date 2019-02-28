/**
 * 
 */
package cn.jhl.smms.ui;
import javax.swing.*;
/**
 * 功能描述：欢迎面板
 * 
 * @author 贾恒
 * @Date 2018年7月18日 下午1:06:49
 * @version 1.0.0
 */
public class WelcomePanel  extends JFrame {
	private static final long serialVersionUID = 1L;

	public WelcomePanel() {
		try {
			Init();
		} catch (Exception err) {
			err.printStackTrace();
		}
	}

	/**
	 * 
	 * 功能描述：登录成功后开启欢迎面板，手动关闭后开启管理面板
	 * 
	 * @author 贾恒
	 * @Date 2018年7月18日 下午1:10:21
	 * @version 1.0.0
	 */
	private void Init() throws Exception {
		JOptionPane.showMessageDialog(null, "欢迎使用运动会管理系统！");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
		new Manage(); // 开启管理面板
	}
}