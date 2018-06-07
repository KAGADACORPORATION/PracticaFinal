package control;

import javax.swing.JPanel;
import acciones.AddLinea;
import acciones.BuscarArticulo;
import acciones.BuscarClienteKey;
import acciones.GuardarCliente;
import acciones.ListenerAccederAltaArticulo;
import acciones.ListenerAccederAltaCliente;
import acciones.ListenerAccederAltaPedido;
import acciones.ListenerAccederBuscarArticulo;
import acciones.ListenerAccederBuscarCliente;
import acciones.ListenerAccederBuscarPedido;
import acciones.ListenerArticulo;
import acciones.ListenerPedido;
import acciones.RegistrarArticulo;
import acciones.ListenerCliente;
import acciones.RegistrarPedido;
import vista.VistaPrincipal;
import acciones.ListenerElegirClientePedido;

public class Puente extends VistaPrincipal {

	private Logica logica;
	private Validador validador;

	public Puente() {
		super();
		this.validador = new Validador(this);
		this.logica = new Logica(this.validador);
		asignarListeners();
	}

	private void asignarListeners() {
		asignarListenerArticulos();
		asignarListenerClientes();
		asignarListenerPedidos();
	}

	private void asignarListenerPedidos() {
		this.panelPedido.getBotonPedido().addActionListener(new ListenerPedido(this));
		
		this.panelPedido.getBtnAccederAltaPedido().addActionListener(new ListenerAccederAltaPedido(this));
		this.panelPedido.getBtnConsultarPedidos().addActionListener(new ListenerAccederBuscarPedido(this));
		
		this.mntmBuscarPedido.addActionListener(new ListenerAccederBuscarPedido(this));
		this.mntmNuevoPedido.addActionListener(new ListenerAccederAltaPedido(this));
		
		this.panelPedido.getBotonPedido().addActionListener(new RegistrarPedido(this));
		this.getVistaEjecutarAltaPedido().getButtonBuscarCliente().addActionListener(new ListenerElegirClientePedido(this));
		
	}

	private void asignarListenerArticulos() {
		
		this.getBotonArticulo().addActionListener(new ListenerArticulo(this));
		
		this.panelArticulo.getBotonBuscarArticulo().addActionListener(new ListenerAccederBuscarArticulo(this));
		this.panelArticulo.getBotonAltaArticulo().addActionListener(new ListenerAccederAltaArticulo(this));
		
		this.mntmBuscarArticulo.addActionListener(new ListenerAccederBuscarArticulo(this));
		this.mntmDarDeAlta.addActionListener(new ListenerAccederAltaArticulo(this));
		
		this.getVistaEjecutarAltaArticulo().getBtnGuardar().addActionListener(new RegistrarArticulo(this,validador));
		this.getVistaEjecutarBuscarArticulo().getTextBuscarBuscarArticulo().addKeyListener(new BuscarArticulo(this));
	}

	private void asignarListenerClientes() {
		this.panelCliente.getBotonCliente().addActionListener(new ListenerCliente(this));
		
		this.panelCliente.getBtnAltaCliente().addActionListener(new ListenerAccederAltaCliente(this));
		this.panelCliente.getBtnBuscarCliente().addActionListener(new ListenerAccederBuscarCliente(this));
		
		this.mntmBuscarCliente.addActionListener(new ListenerAccederBuscarCliente(this));
		this.mntmDarAltaCliente.addActionListener(new ListenerAccederAltaCliente(this));
		
		this.getVistaAccederAltaCliente().getVistaEjecutarAltaCliente().getBtnValidar().addActionListener(new GuardarCliente(this));
		this.getVistaAccederBuscarCliente().getVistaEjecutarBuscarCliente().getTextField().addKeyListener(new BuscarClienteKey(this));
	}

	
	
	public Logica getLogica() {
		return logica;
	}

	public Validador getValidador() {
		return validador;
	}
}