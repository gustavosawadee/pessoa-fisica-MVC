   	import java.awt.BorderLayout;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	import javax.swing.JFrame;
	import javax.swing.JMenu;
	import javax.swing.JMenuBar;
	import javax.swing.JMenuItem;

	import org.hibernate.Session;

	import model.PessoaFisica;
	import persistence.PessoaHibernateDAO;
	import persistence.Hibernateutil;

	public class App extends JFrame{
		private JMenuBar menuBar;
		private JMenu menu;
		private JMenuItem menuItem;
			
		TelaDeCadastro tlaCadPessoa = new TelaCadPessoa();
		
		public App() {
			this.setVisible(true);
			this.setSize(800, 600);
			this.setLayout(new BorderLayout());
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			
			configuraMenu();
			this.pack();
		}
		
		private void configuraMenu() {
			this.menuBar = new JMenuBar();
			JMenu menuCadastros = new JMenu("Cadastros");
			
			JMenuItem menuItemClientes = new JMenuItem("PessoaFisica");
			menuItemClientes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("menuClieActionPerformed...");
					App.this.tlaCadPessoa.setVisible(true);
					App.this.getContentPane().add(App.this.tlaCadPessoa, BorderLayout.CENTER);
					App.this.pack();
				}
			});
			menuCadastros.add(menuItemClientes);
			
			JMenuItem menuItemHardware = new JMenuItem("Hardware");
			menuItemHardware.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					App.this.tlaCadPessoa.setVisible(false);
					App.this.getContentPane().add(App.this.tlaCadPessoa, BorderLayout.CENTER);
					App.this.pack();
				}
			});
			menuCadastros.add(menuItemHardware);
			
			JMenuItem menuItemVenda = new JMenuItem("Vendas");
			menuItemVenda.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					App.this.tlaCadPessoa.setVisible(false);
					App.this.getContentPane().add(App.this.tlaCadVdas, BorderLayout.CENTER);
					App.this.pack();
				}
			});
			menuCadastros.add(menuItemVenda);
			
			this.menuBar.add(menuCadastros);
			this.getContentPane().add(menuBar, BorderLayout.NORTH);
			
		}
		
		public static void main( String[] args){
			App app = new App();
			
			/*Cliente c1 = new Cliente();
			
			c1.setNome("cozinheiro");
			c1.setEndereco("End do cozinheiro");
			c1.setFone("11-981300452");
			c1.setEmail("cozinheiro@hotmail.com");
			
			Session session = Hibernateutil.getSessionFactory().openSession();
			ClienteHibernateDAO<Cliente> clienteDao = new ClienteHibernateDAO<Cliente>(session);
			clienteDao.persistir(c1);
			clienteDao.commit();
			clienteDao.closeSession();*/
		}
	}
