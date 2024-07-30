package com.utn.ElBuenSabor.services;

import com.utn.ElBuenSabor.dtos.DTOCambiarEstado;
import com.utn.ElBuenSabor.entities.Pedido;
import com.utn.ElBuenSabor.repositories.BaseRepository;
import com.utn.ElBuenSabor.repositories.PedidoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServiceImpl extends BaseServiceImpl<Pedido, Long> implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public PedidoServiceImpl(BaseRepository<Pedido, Long> baseRepository, PedidoRepository pedidoRepository) {
        super(baseRepository);
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public List<Pedido> search(String filtro) throws Exception {
        try{
            List<Pedido> pedido = pedidoRepository.searchNativo(filtro);
            return pedido;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Pedido> search(String filtro, Pageable pageable) throws Exception {
        try{
            Page<Pedido> pedido = pedidoRepository.searchNativo(filtro, pageable);
            return pedido;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    //Cambiar estado pedido
    @Override
    public Pedido cambiarEstado(DTOCambiarEstado cambiarEstadoDTO) throws Exception{
        try{
            Pedido pedido = pedidoRepository.findById(cambiarEstadoDTO.getIdPedido()).get();

            pedido.setEstado(cambiarEstadoDTO.getEstadoPedido());

            pedidoRepository.save(pedido);

            return pedido;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Pedido> findPedidosCliente(Long idCliente) throws Exception{
        try{
            List<Pedido> pedidos = pedidoRepository.findPedidosCliente(idCliente);
            return pedidos;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}