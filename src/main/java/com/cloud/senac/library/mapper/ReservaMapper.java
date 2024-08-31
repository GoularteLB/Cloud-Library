package com.cloud.senac.library.mapper;

import com.cloud.senac.library.dto.LivroDto;
import com.cloud.senac.library.dto.UsuarioDto;
import com.cloud.senac.library.dto.auth.RegisterDto;
import com.cloud.senac.library.dto.reserva.CadastroReservaDto;
import com.cloud.senac.library.dto.reserva.ReservaDto;
import com.cloud.senac.library.entity.Livro;
import com.cloud.senac.library.entity.Reserva;
import com.cloud.senac.library.entity.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReservaMapper implements IReservaMapper<ReservaDto, CadastroReservaDto, Reserva>{

    private final IGenericMapper<LivroDto, Livro> livroMapper;
    private final IUsuarioMapper<UsuarioDto, Usuario, RegisterDto> usuarioMapper;

    @Override
    public Reserva convertDtoCadastroToEntity(CadastroReservaDto dto) {
        Reserva reserva = new Reserva();
        reserva.setDataFinal(dto.dataFinal());
        reserva.setMultaPorDia(dto.multaPorDia());
        Usuario usuario = new Usuario();
        usuario.setId(dto.usuarioId());
        reserva.setUsuario(usuario);
        return reserva;
    }

    @Override
    public ReservaDto toDTO(Reserva entity) {
        return new ReservaDto(
                entity.getId(), entity.getDataInicial(), entity.getDataFinal(), entity.getDataEntrega(),
                usuarioMapper.toDTO(entity.getUsuario()),
                entity.getLivroList().stream().map(livroMapper::toDTO).toList(),
                entity.getMultaPorDia(),
                null
        );
    }

    @Override
    public Reserva toEntity(ReservaDto dto) {
        return null;
    }
}
