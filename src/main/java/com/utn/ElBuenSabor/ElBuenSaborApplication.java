package com.utn.ElBuenSabor;

import com.utn.ElBuenSabor.entities.*;
import com.utn.ElBuenSabor.enums.*;
import com.utn.ElBuenSabor.repositories.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@SpringBootApplication
public class ElBuenSaborApplication {

	@Autowired
	public DomicilioRepository domicilioRepository;
	@Autowired
	public PersonaRepository personaRepository;
	@Autowired
	public UsuarioRepository usuarioRepository;
	@Autowired
	public ArticuloManufacturadoRepository articuloManufacturadoRepository;
	@Autowired
	public UnidadMedidaRepository unidadMedidaRepository;
	@Autowired
	public ArticuloInsumoRepository articuloInsumoRepository;
	@Autowired
	public RubroArticuloManufacturadoRepository rubroArticuloRepository;
	@Autowired
	public RubroArticuloInsumoRepository rubroArticuloInsumoRepository;
	@Autowired
	public RecetaRepository recetaRepository;

	@Autowired
	public FacturaRepository facturaRepository;

	@Autowired
	public DetalleArticuloManufacturadoRepository detalleArticuloManufacturadoRepository;

	@Autowired
	public DetallePedidoRepository detallePedidoRepository;

	@Autowired
	public CarritoProductoRepository carritoProductoRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	public CarritoRepository carritoRepository;

	@Autowired
	public DetalleFacturaRepository detalleFacturaRepository;

	@Autowired
	public PedidoRepository pedidoRepository;

	@Autowired
	public NotaCreditoRepository notaCreditoRepository;
	public static void main(String[] args) {
		SpringApplication.run(ElBuenSaborApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UsuarioRepository usuarioRepo, PersonaRepository clienteRepo, DomicilioRepository domicilioRepo ) {
		return args -> {
			System.out.println("-----------------ESTOY FUNCIONANDO---------");

			Date fechaActual = new Date();
			TimeZone timeZone = TimeZone.getDefault();

			//Crea usuarios
			Usuario usuario1 = Usuario.builder()
					.auth0Id("auth0Id123")
					.username("username123")
					.password(passwordEncoder.encode("1234"))
					.rol(Rol.CLIENTE)
					.build();
			usuario1.setSubmissionDateAlta(fechaActual);


			Usuario usuario2 = Usuario.builder()
					.auth0Id("auth0Id1234")
					.username("username1234")
					.password("123")
					.rol(Rol.ADMINISTRADOR)
					.build();
			usuario2.setSubmissionDateAlta(fechaActual);

			Usuario usuario3 = Usuario.builder()
					.auth0Id("auth0Id12345")
					.username("username12345")
					.password("123")
					.rol(Rol.COCINERO)
					.build();
			usuario3.setSubmissionDateAlta(fechaActual);

			Usuario usuario4 = Usuario.builder()
					.auth0Id("auth0Id123456")
					.username("username123456")
					.password("123")
					.rol(Rol.DELIVERY)
					.build();
			usuario4.setSubmissionDateAlta(fechaActual);

			Domicilio domicilio1 = Domicilio.builder()
					.calle("Calle 1")
					.codigoPostal(1111)
					.pisoDpto(1)
					.numero(1234)
					.numeroDpto(12)
					.build();
			domicilio1.setSubmissionDateAlta(fechaActual);

			Domicilio domicilio2 = Domicilio.builder()
					.calle("Calle 2")
					.codigoPostal(2222)
					.pisoDpto(2)
					.numero(1234)
					.numeroDpto(12)
					.build();
			domicilio2.setSubmissionDateAlta(fechaActual);

			//Crea y agrega domicilios al cliente asociado a este usuario
			Persona cliente1 = Persona.builder()
					.apellido("Apellido")
					.email("cliente@example.com")
					.nombre("Nombre")
					.telefono("123-456-7890")
					.domicilios(List.of(domicilio1,domicilio2))
					.usuario(usuario4)
					.build();
			cliente1.setSubmissionDateAlta(fechaActual);
			personaRepository.save(cliente1);
 			//----------------cliente 2------------------------------

			// Crear otro cliente asociado a usuario1
			Domicilio domicilio3 = Domicilio.builder()
					.calle("Calle 3")
					.codigoPostal(3333)
					.pisoDpto(3)
					.numero(5678)
					.numeroDpto(34)
					.build();
			domicilio3.setSubmissionDateAlta(fechaActual);

			// Crear un nuevo cliente asociado a usuario1
			Persona cliente2 = Persona.builder()
					.apellido("ApellidoCliente2")
					.email("cliente2@example.com")
					.nombre("NombreCliente2")
					.telefono("987-654-3210")
					.domicilios(List.of(domicilio3))
					.usuario(usuario1)  // asociar con usuario1
					.build();
			cliente2.setSubmissionDateAlta(fechaActual);
			personaRepository.save(cliente2);

			Domicilio domicilioEmpleado1 = Domicilio.builder()
					.calle("Calle empleado 1")
					.codigoPostal(5501)
					.localidad("Godoy Cruz")
					.numero(1803)
					.numeroDpto(1)
					.pisoDpto(2)
					.build();
			domicilioEmpleado1.setSubmissionDateAlta(fechaActual);

			Usuario usuarioEmpleado1 = Usuario.builder()
					.auth0Id("auth123122312312")
					.username("userEmpleado1")
					.password("1234")
					.rol(Rol.CAJERO)
					.build();
			usuarioEmpleado1.setSubmissionDateAlta(fechaActual);

			Persona empleado1 = Persona.builder()
					.apellido("Empleado")
					.nombre("1")
					.domicilios(List.of(domicilioEmpleado1))
					.email("empleado1@gmail.com")
					.telefono("2616150281")
					.usuario(usuarioEmpleado1)
					.build();
			empleado1.setSubmissionDateAlta(fechaActual);
			personaRepository.save(empleado1);

			Domicilio domicilioEmpleado2 = Domicilio.builder()
					.calle("Calle empleado 1")
					.codigoPostal(5501)
					.localidad("Godoy Cruz")
					.numero(1803)
					.numeroDpto(1)
					.pisoDpto(2)
					.build();
			domicilioEmpleado2.setSubmissionDateAlta(fechaActual);

			Usuario usuarioEmpleado2 = Usuario.builder()
					.auth0Id("auth123122312313")
					.username("userEmpleado1")
					.password("1234")
					.rol(Rol.ADMINISTRADOR)
					.build();
			usuarioEmpleado2.setSubmissionDateAlta(fechaActual);

			Persona empleado2 = Persona.builder()
					.apellido("Empleado")
					.nombre("2")
					.domicilios(List.of(domicilioEmpleado2))
					.email("empleado2@gmail.com")
					.telefono("2616150281")
					.usuario(usuarioEmpleado2)
					.build();
			empleado1.setSubmissionDateAlta(fechaActual);
			personaRepository.save(empleado2);

			Domicilio domicilioEmpleado3 = Domicilio.builder()
					.calle("Calle empleado 1")
					.codigoPostal(5501)
					.localidad("Godoy Cruz")
					.numero(1803)
					.numeroDpto(1)
					.pisoDpto(2)
					.build();
			domicilioEmpleado3.setSubmissionDateAlta(fechaActual);


			Usuario usuarioEmpleado3 = Usuario.builder()
					.auth0Id("auth123122312315")
					.username("userEmpleado1")
					.password("1234")
					.rol(Rol.COCINERO)
					.build();
			usuarioEmpleado3.setSubmissionDateAlta(fechaActual);

			Persona empleado3 = Persona.builder()
					.apellido("Empleado")
					.nombre("3")
					.domicilios(List.of(domicilioEmpleado3))
					.email("empleado3@gmail.com")
					.telefono("2616150281")
					.usuario(usuarioEmpleado3)
					.build();
			empleado3.setSubmissionDateAlta(fechaActual);
			personaRepository.save(empleado3);

			// Guardar el nuevo cliente en el repositorio ?????????????????????? porq aca soy vale, de donde sale esto=?
			personaRepository.save(cliente2);
			
            //-------------------------------------------------

			UnidadMedida unidadMedidaKg = UnidadMedida.builder()
					.abreviatura("kg")
					.denominacion("Kilogramo")
					.build();
			unidadMedidaKg.setSubmissionDateAlta(fechaActual);
			unidadMedidaRepository.save(unidadMedidaKg);

			RubroArticuloManufacturado rubroArticuloHamburguesa = RubroArticuloManufacturado.builder()
					.denominacion("Hamburguesa")
					.rubroPadre(null)
					.build();
			rubroArticuloHamburguesa.setSubmissionDateAlta(fechaActual);
			rubroArticuloRepository.save((rubroArticuloHamburguesa));

			RubroArticuloInsumo rubroArticuloInsumo1 = RubroArticuloInsumo.builder()
					.denominacion("Panificados")
					.build();
			rubroArticuloInsumo1.setSubmissionDateAlta(fechaActual);
			rubroArticuloInsumoRepository.save(rubroArticuloInsumo1);

			RubroArticuloInsumo rubroArticuloInsumo2 = RubroArticuloInsumo.builder()
					.denominacion("Verduras")
					.build();
			rubroArticuloInsumo2.setSubmissionDateAlta(fechaActual);
			rubroArticuloInsumoRepository.save(rubroArticuloInsumo2);

			RubroArticuloInsumo rubroArticuloInsumo3 = RubroArticuloInsumo.builder()
					.denominacion("Carnes")
					.build();
			rubroArticuloInsumo3.setSubmissionDateAlta(fechaActual);
			rubroArticuloInsumoRepository.save(rubroArticuloInsumo3);

			RubroArticuloInsumo rubroArticuloInsumo4 = RubroArticuloInsumo.builder()
					.denominacion("Lacteos")
					.build();
			rubroArticuloInsumo4.setSubmissionDateAlta(fechaActual);
			rubroArticuloInsumoRepository.save(rubroArticuloInsumo4);

			ArticuloInsumo articuloInsumo1= ArticuloInsumo.builder()
					.denominacion("Harina")
					.precioCompra(BigDecimal.valueOf(15.00))
					.stockActual(BigDecimal.valueOf(20.00))
					.stockMinimo(BigDecimal.valueOf(10.00))
					.urlImagen(null)
					.unidadMedida(unidadMedidaKg)
					.rubroArticulo(rubroArticuloInsumo1)
					.build();
			articuloInsumo1.setSubmissionDateAlta(fechaActual);
			articuloInsumoRepository.save(articuloInsumo1);

			ArticuloInsumo articuloInsumo2= ArticuloInsumo.builder()
					.denominacion("Cebolla")
					.precioCompra(BigDecimal.valueOf(600))
					.stockActual(BigDecimal.valueOf(20))
					.stockMinimo(BigDecimal.valueOf(5))
					.urlImagen(null)
					.unidadMedida(unidadMedidaKg)
					.rubroArticulo(rubroArticuloInsumo2)
					.build();
			articuloInsumo2.setSubmissionDateAlta(fechaActual);
			articuloInsumoRepository.save(articuloInsumo2);

			ArticuloInsumo articuloInsumo3= ArticuloInsumo.builder()
					.denominacion("Bacon")
					.precioCompra(BigDecimal.valueOf(5500))
					.stockActual(BigDecimal.valueOf(1))
					.stockMinimo(BigDecimal.valueOf(0.250))
					.urlImagen(null)
					.unidadMedida(unidadMedidaKg)
					.rubroArticulo(rubroArticuloInsumo3)
					.build();
			articuloInsumo3.setSubmissionDateAlta(fechaActual);
			articuloInsumoRepository.save(articuloInsumo3);

			ArticuloInsumo articuloInsumo4 = ArticuloInsumo.builder()
					.denominacion("Tomate")
					.precioCompra(BigDecimal.valueOf(1500))
					.stockActual(BigDecimal.valueOf(5))
					.stockMinimo(BigDecimal.valueOf(1))
					.urlImagen(null)
					.unidadMedida(unidadMedidaKg)
					.rubroArticulo(rubroArticuloInsumo2)
					.build();
			articuloInsumo4.setSubmissionDateAlta(fechaActual);
			articuloInsumoRepository.save(articuloInsumo4);

			ArticuloInsumo articuloInsumo5= ArticuloInsumo.builder()
					.denominacion("Palta")
					.precioCompra(BigDecimal.valueOf(2500))
					.stockActual(BigDecimal.valueOf(3))
					.stockMinimo(BigDecimal.valueOf(1))
					.urlImagen(null)
					.unidadMedida(unidadMedidaKg)
					.rubroArticulo(rubroArticuloInsumo2)
					.build();
			articuloInsumo5.setSubmissionDateAlta(fechaActual);
			articuloInsumoRepository.save(articuloInsumo5);

			ArticuloInsumo articuloInsumo6= ArticuloInsumo.builder()
					.denominacion("Levadura")
					.precioCompra(BigDecimal.valueOf(1000))
					.stockActual(BigDecimal.valueOf(0.3))
					.stockMinimo(BigDecimal.valueOf(0.1))
					.urlImagen(null)
					.unidadMedida(unidadMedidaKg)
					.rubroArticulo(rubroArticuloInsumo1)
					.build();
			articuloInsumo6.setSubmissionDateAlta(fechaActual);
			articuloInsumoRepository.save(articuloInsumo6);

			ArticuloInsumo articuloInsumo7= ArticuloInsumo.builder()
					.denominacion("Medallon de carne")
					.precioCompra(BigDecimal.valueOf(4500))
					.stockActual(BigDecimal.valueOf(15))
					.stockMinimo(BigDecimal.valueOf(5))
					.urlImagen(null)
					.unidadMedida(unidadMedidaKg)
					.rubroArticulo(rubroArticuloInsumo3)
					.build();
			articuloInsumo7.setSubmissionDateAlta(fechaActual);
			articuloInsumoRepository.save(articuloInsumo7);

			ArticuloInsumo articuloInsumo8= ArticuloInsumo.builder()
					.denominacion("Cheddar")
					.precioCompra(BigDecimal.valueOf(3900))
					.stockActual(BigDecimal.valueOf(3))
					.stockMinimo(BigDecimal.valueOf(1))
					.urlImagen(null)
					.unidadMedida(unidadMedidaKg)
					.rubroArticulo(rubroArticuloInsumo4)
					.build();
			articuloInsumo8.setSubmissionDateAlta(fechaActual);
			articuloInsumoRepository.save(articuloInsumo8);

			ArticuloInsumo articuloInsumo9 = ArticuloInsumo.builder()
					.denominacion("Nachos")
					.precioCompra(BigDecimal.valueOf(1500))
					.stockActual(BigDecimal.valueOf(2))
					.stockMinimo(BigDecimal.valueOf(0.3))
					.urlImagen(null)
					.unidadMedida(unidadMedidaKg)
					.rubroArticulo(rubroArticuloInsumo4)
					.build();
			articuloInsumo9.setSubmissionDateAlta(fechaActual);
			articuloInsumoRepository.save(articuloInsumo9);

			Receta receta1 = Receta.builder()
					.nombreReceta("MasapPizza")
					.descripcionReceta("Mezclar 50gr de levadura con 50ml de agua, cuando se disuelva agregarlo al kg de harina. Luego agregar 600ml de agua y una pizca de sal. Amasar durante 5 minutos, dejar leudar hasta duplicar tamaño, luego estirar al tamaño del molde")
					.tiempoPreparacion(30)
					.build();
			receta1.setSubmissionDateAlta(fechaActual);
			recetaRepository.save(receta1);

			Receta receta2 = Receta.builder()
					.nombreReceta("Guacamole")
					.descripcionReceta("Cortar 1 tomate en dados, pisar 2 paltas, agregar tomate a la palta y condimentar con sal y pimienta a gusto, picar cilantro a gusto y agregar a mezcla final")
					.tiempoPreparacion(10)
					.build();
			receta2.setSubmissionDateAlta(fechaActual);
			recetaRepository.save(receta2);

			Receta receta3 = Receta.builder()
					.nombreReceta("MasapHamburguesa")
					.descripcionReceta("Mezclar 50gr de levadura con 50ml de agua, cuando se disuelva agregarlo al kg de harina. Luego agregar 300ml de agua, 300ml de leche y una pizca de sal. Amasar durante 5 minutos, dejar leudar hasta duplicar tamaño, luego estirar al tamaño del molde")
					.tiempoPreparacion(30)
					.build();
			receta3.setSubmissionDateAlta(fechaActual);
			recetaRepository.save(receta3);

			DetalleArticuloManufacturado detalleArticuloManufacturado1 = DetalleArticuloManufacturado.builder()
					.cantidad(BigDecimal.valueOf(1))
					.articuloInsumo(articuloInsumo1)
					.build();
			detalleArticuloManufacturado1.setSubmissionDateAlta(fechaActual);
			detalleArticuloManufacturadoRepository.save(detalleArticuloManufacturado1);

			RubroArticuloManufacturado rubroArticuloManufacturadoPizza = RubroArticuloManufacturado.builder()
					.denominacion("Pizzas")
					.build();
			rubroArticuloManufacturadoPizza.setSubmissionDateAlta(fechaActual);
			rubroArticuloRepository.save(rubroArticuloManufacturadoPizza);

			RubroArticuloManufacturado rubroArticuloManufacturadoHamburguesa = RubroArticuloManufacturado.builder()
					.denominacion("Hamburguesa")
					.build();
			rubroArticuloHamburguesa.setSubmissionDateAlta(fechaActual);
			rubroArticuloRepository.save(rubroArticuloManufacturadoHamburguesa);

			RubroArticuloManufacturado rubroArticuloManufacturadoPapas = RubroArticuloManufacturado.builder()
					.denominacion("Papas Fritas")
					.build();
			rubroArticuloManufacturadoPapas.setSubmissionDateAlta(fechaActual);
			rubroArticuloRepository.save(rubroArticuloManufacturadoPapas);

			ArticuloManufacturado articuloManufacturado1 = ArticuloManufacturado.builder()
					.costo(BigDecimal.valueOf(1850))
					.denominacion("Pizza fugazza")
					.descripcion("Pizza con cebolla")
					.precioVenta(BigDecimal.valueOf(6550))
					.categoria(CategoriaProducto.PIZZA)
					.tiempoEstimadoCocina(15)
					.urlImagen("URLPizza")
					.detalleArticuloManufacturado(List.of(detalleArticuloManufacturado1))
					.rubroArticuloManufacturado(rubroArticuloManufacturadoPizza)
					.receta(receta1)
					.build();
			articuloManufacturado1.setSubmissionDateAlta(fechaActual);
			articuloManufacturadoRepository.save(articuloManufacturado1);

			ArticuloManufacturado articuloManufacturado2 = ArticuloManufacturado.builder()
					.costo(BigDecimal.valueOf(1500))
					.denominacion("Hamburguesa Americana")
					.descripcion("Hamburugesa con bacon y cheddar")
					.precioVenta(BigDecimal.valueOf(3200))
					.categoria(CategoriaProducto.HAMBUERGUESA)
					.tiempoEstimadoCocina(20)
					.urlImagen("")
					.rubroArticuloManufacturado(rubroArticuloManufacturadoHamburguesa)
					.receta(receta2)
					.build();
			articuloManufacturado2.setSubmissionDateAlta(fechaActual);
			articuloManufacturadoRepository.save(articuloManufacturado2);

			ArticuloManufacturado articuloManufacturado3 = ArticuloManufacturado.builder()
					.costo(BigDecimal.valueOf(1650))
					.denominacion("Hamburguesa TexMex")
					.descripcion("Hamburugesa doble con guacamole y nachos")
					.precioVenta(BigDecimal.valueOf(3350))
					.categoria(CategoriaProducto.HAMBUERGUESA)
					.tiempoEstimadoCocina(15)
					.urlImagen("")
					.rubroArticuloManufacturado(rubroArticuloManufacturadoHamburguesa)
					.receta(receta3)
					.build();
			articuloManufacturado3.setSubmissionDateAlta(fechaActual);
			articuloManufacturadoRepository.save(articuloManufacturado3);

			CarritoProducto carritoProducto1 = CarritoProducto.builder()
					.cantidadProductoCarrito(1)
					.numeroLinea(1)
					.articuloManufacturado(articuloManufacturado1)
					.build();
			carritoProducto1.setSubmissionDateAlta(fechaActual);
			carritoProductoRepository.save(carritoProducto1);

			CarritoProducto carritoProducto2 = CarritoProducto.builder()
					.cantidadProductoCarrito(1)
					.numeroLinea(2)
					.articuloManufacturado(articuloManufacturado2)
					.build();
			carritoProducto2.setSubmissionDateAlta(fechaActual);
			carritoProductoRepository.save(carritoProducto2);

			CarritoProducto carritoProducto3 = CarritoProducto.builder()
					.cantidadProductoCarrito(1)
					.numeroLinea(3)
					.articuloManufacturado(articuloManufacturado3)
					.build();
			carritoProducto3.setSubmissionDateAlta(fechaActual);
			carritoProductoRepository.save(carritoProducto3);

			Carrito carrito1 = Carrito.builder()
					.numeroCarrito(1)
					.carritoProductos(List.of(carritoProducto1, carritoProducto2, carritoProducto3))
					.build();
			carrito1.setSubmissionDateAlta(fechaActual);

			Carrito carrito2 = Carrito.builder()
					.numeroCarrito(2)
					.carritoProductos(List.of(carritoProducto1, carritoProducto2))
					.build();
			carrito2.setSubmissionDateAlta(fechaActual);

			Carrito carrito3 = Carrito.builder()
					.numeroCarrito(3)
					.carritoProductos(List.of(carritoProducto1))
					.build();
			carrito3.setSubmissionDateAlta(fechaActual);


			DetallePedido detallePedido1 = DetallePedido.builder()
					.cantidad(1)
					.subtotal(BigDecimal.valueOf(3.0))
					.subtotalCosto(BigDecimal.valueOf(3.0))
					.articuloManufacturado(articuloManufacturado1)
					.build();
			detallePedido1.setSubmissionDateAlta(fechaActual);

			DetallePedido detallePedido2 = DetallePedido.builder()
					.cantidad(2)
					.subtotal(BigDecimal.valueOf(4.0))
					.subtotalCosto(BigDecimal.valueOf(8.0))
					.articuloManufacturado(articuloManufacturado2)
					.build();
			detallePedido2.setSubmissionDateAlta(fechaActual);

			DetallePedido detallePedido3 = DetallePedido.builder()
					.cantidad(3)
					.subtotal(BigDecimal.valueOf(5.0))
					.subtotalCosto(BigDecimal.valueOf(15.0))
					.articuloManufacturado(articuloManufacturado2)
					.build();
			detallePedido3.setSubmissionDateAlta(fechaActual);

			NotaCredito notaCredito1 = NotaCredito.builder()
					.factura(null)
					.persona(cliente1)
					.monto(BigDecimal.valueOf(20.0))
					.build();
			notaCreditoRepository.save(notaCredito1);


			DetalleFactura detalleFactura1 = DetalleFactura.builder()
					.cantidad(1)
					.subtotal(BigDecimal.valueOf(12000))
					.articuloManufacturado(articuloManufacturado1)
					.build();
			detalleFactura1.setSubmissionDateAlta(fechaActual);

			DetalleFactura detalleFactura2 = DetalleFactura.builder()
					.cantidad(2)
					.subtotal(BigDecimal.valueOf(13000))
					.articuloManufacturado(articuloManufacturado2)
					.build();
			detalleFactura2.setSubmissionDateAlta(fechaActual);


			DetalleFactura detalleFactura3 = DetalleFactura.builder()
					.cantidad(3)
					.subtotal(BigDecimal.valueOf(15000))
					.articuloManufacturado(articuloManufacturado3)
					.build();
			detalleFactura3.setSubmissionDateAlta(fechaActual);


			Factura factura1 = Factura.builder()
					.fechaFacturacion(fechaActual)
					.mpPaymentId(001L)
					.mpMerchantOrderId(135456L)
					.mpPreferenceId("")
					.mpPaymentType("Tarjeta")
					.formaPago(FormaPago.MERCADO_PAGO)
					.totalVenta(BigDecimal.valueOf(12000))
					.build();
			factura1.setSubmissionDateAlta(fechaActual);
			//esto esta bien asi o es con la list.of() ??
			factura1.agregarDetalle(detalleFactura1);
			//

			Factura factura2 = Factura.builder()
					.fechaFacturacion(fechaActual)
					.mpPaymentId(001L)
					.mpMerchantOrderId(135456L)
					.mpPreferenceId("")
					.mpPaymentType("Efectivo")
					.formaPago(FormaPago.EFECTIVO)
					.totalVenta(BigDecimal.valueOf(13000))
					.build();
			factura2.setSubmissionDateAlta(fechaActual);
			factura2.agregarDetalle(detalleFactura2);

			Factura factura3 = Factura.builder()
					.fechaFacturacion(fechaActual)
					.mpPaymentId(001L)
					.mpMerchantOrderId(135456L)
					.mpPreferenceId("")
					.mpPaymentType("Efectivo")
					.formaPago(FormaPago.EFECTIVO)
					.totalVenta(BigDecimal.valueOf(15000))
					.build();
			factura3.setSubmissionDateAlta(fechaActual);
			factura3.agregarDetalle(detalleFactura3);

			Date fechaActualnew = new Date();

			// Define el formato deseado
			String formatoFecha = "yyyy-MM-dd HH:mm:ss";

			// Crea un objeto SimpleDateFormat con el formato especificado
			SimpleDateFormat sdf = new SimpleDateFormat(formatoFecha);

			// Formatea la fecha según el patrón definido
			String fechaFormateada = sdf.format(fechaActualnew);

			Pedido pedido1 = Pedido.builder()
					.factura(factura1)
					.detalles(List.of(detallePedido1))
					.estado(EstadoPedido.A_PREPARAR)
					.formaPago(FormaPago.MERCADO_PAGO)
					.horaEstimadaFinalizacion(fechaActualnew)
					.tipoEnvio(TipoEnvio.DELIVERY)
					.total(BigDecimal.valueOf(10000))
					.totalCosto(BigDecimal.valueOf(600))
					.carrito(carrito1)
					.persona(cliente2)
					.domicilioEntrega(domicilio1)
					.fechaPedido(fechaActualnew)
					.build();
			pedido1.setSubmissionDateAlta(fechaActual);
			pedidoRepository.save(pedido1);

			Pedido pedido2 = Pedido.builder()
					.factura(factura2)
					.detalles(List.of(detallePedido2))
					.estado(EstadoPedido.EN_CAMINO)
					.formaPago(FormaPago.EFECTIVO)
					.horaEstimadaFinalizacion(fechaActualnew)
					.tipoEnvio(TipoEnvio.TAKE_AWAY)
					.total(BigDecimal.valueOf(12000))
					.totalCosto(BigDecimal.valueOf(800))
					.carrito(carrito2)
					.persona(cliente2)
					.domicilioEntrega(domicilio2)
					.fechaPedido(fechaActualnew)
					.build();
			pedido2.setSubmissionDateAlta(fechaActual);
			pedidoRepository.save(pedido2);

			Pedido pedido3 = Pedido.builder()
					.factura(factura3)
					.detalles(List.of(detallePedido3))
					.estado(EstadoPedido.PAGADO)
					.formaPago(FormaPago.EFECTIVO)
					.horaEstimadaFinalizacion(fechaActualnew)
					.tipoEnvio(TipoEnvio.TAKE_AWAY)
					.total(BigDecimal.valueOf(15000))
					.totalCosto(BigDecimal.valueOf(800))
					.carrito(carrito3)
					.persona(cliente1)
					.domicilioEntrega(domicilio3)
					.fechaPedido(fechaActualnew)
					.build();
			pedido3.setSubmissionDateAlta(fechaActual);
			pedidoRepository.save(pedido3);


			NotaCredito notaCredito = NotaCredito.builder()
					.factura(factura1)
					.monto(factura1.getTotalVenta())
					.persona(cliente1)
					.build();
			notaCredito.setSubmissionDateAlta(fechaActual);
			notaCreditoRepository.save(notaCredito);
		};
	}
}
