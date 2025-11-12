package com.alura.condominio.clearArch.business.impl;

import com.alura.condominio.clearArch.core.exceptions.RecursoNaoEncontradoException;
import com.alura.condominio.clearArch.core.exceptions.RegraDeNegocioException;
import com.alura.condominio.clearArch.domain.Condomino;
import com.alura.condominio.clearArch.service.CondominoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CondominoBusinessImplTest {

    @Mock
    private CondominoService condominoService;

    @InjectMocks
    private CondominoBusinessImpl condominoBusiness;

    @Test
    void cadastrarCondomino_DeveCadastrarQuandoCPFNaoExiste() {
        Condomino condomino = new Condomino();
        condomino.setCpf("12345678900");

        when(condominoService.exiteCPF("12345678900")).thenReturn(false);
        when(condominoService.cadastrar(condomino)).thenReturn(condomino);

        Condomino resultado = condominoBusiness.cadastrarCondomino(condomino);

        assertNotNull(resultado);
        verify(condominoService).exiteCPF("12345678900");
        verify(condominoService).cadastrar(condomino);
    }

    @Test
    void cadastrarCondomino_DeveLancarExcecaoQuandoCPFJaExiste() {
        Condomino condomino = new Condomino();
        condomino.setCpf("12345678900");

        when(condominoService.exiteCPF("12345678900")).thenReturn(true);

        assertThrows(RegraDeNegocioException.class, () -> condominoBusiness.cadastrarCondomino(condomino));
        verify(condominoService).exiteCPF("12345678900");
        verify(condominoService, never()).cadastrar(any());
    }

    @Test
    void deletarCondomino_DeveDeletarQuandoCondominoExiste() {
        when(condominoService.existeCondomino("1")).thenReturn(true);

        condominoBusiness.deletarCondomino("1");

        verify(condominoService).existeCondomino("1");
        verify(condominoService).deletar("1");
    }

    @Test
    void deletarCondomino_DeveLancarExcecaoQuandoCondominoNaoExiste() {
        when(condominoService.existeCondomino("1")).thenReturn(false);

        assertThrows(RecursoNaoEncontradoException.class, () -> condominoBusiness.deletarCondomino("1"));
        verify(condominoService).existeCondomino("1");
        verify(condominoService, never()).deletar(any());
    }

    @Test
    void consultarTodosCondominos_DeveRetornarListaDeCondominos() {
        List<Condomino> condominos = Arrays.asList(new Condomino(), new Condomino());
        when(condominoService.consultarTodos()).thenReturn(condominos);

        List<Condomino> resultado = condominoBusiness.consultarTodosCondominos();

        assertEquals(2, resultado.size());
        verify(condominoService).consultarTodos();
    }

    @Test
    void atualizarCondomino_DeveAtualizarQuandoCondominoExiste() {
        Condomino condomino = new Condomino();
        condomino.setId("1");

        when(condominoService.existeCondomino("1")).thenReturn(true);
        when(condominoService.atualizar(condomino)).thenReturn(condomino);

        Condomino resultado = condominoBusiness.atualizarCondomino(condomino);

        assertNotNull(resultado);
        verify(condominoService).existeCondomino("1");
        verify(condominoService).atualizar(condomino);
    }

    @Test
    void atualizarCondomino_DeveLancarExcecaoQuandoCondominoNaoExiste() {
        Condomino condomino = new Condomino();
        condomino.setId("1");

        when(condominoService.existeCondomino("1")).thenReturn(false);

        assertThrows(RecursoNaoEncontradoException.class, () -> condominoBusiness.atualizarCondomino(condomino));
        verify(condominoService).existeCondomino("1");
        verify(condominoService, never()).atualizar(any());
    }

    @Test
    void consultarCondominoComFiltros_DeveConsultarComTodosFiltros() {
        List<Condomino> condominos = Arrays.asList(new Condomino());
        when(condominoService.consultarPorFiltros("João", "12345678900", "A", "101")).thenReturn(condominos);

        List<Condomino> resultado = condominoBusiness.consultarCondominoComFiltros("João", "12345678900", "A", "101");

        assertEquals(1, resultado.size());
        verify(condominoService).consultarPorFiltros("João", "12345678900", "A", "101");
    }

    @Test
    void consultarCondominoComFiltros_DeveConsultarComFiltrosParciais() {
        List<Condomino> condominos = Arrays.asList(new Condomino());
        when(condominoService.consultarPorFiltros("João", "", "", "")).thenReturn(condominos);

        List<Condomino> resultado = condominoBusiness.consultarCondominoComFiltros("João", null, null, null);

        assertEquals(1, resultado.size());
        verify(condominoService).consultarPorFiltros("João", "", "", "");
    }

    @Test
    void consultarCondominoComFiltros_DeveLancarExcecaoQuandoNenhumFiltroInformado() {
        assertThrows(RegraDeNegocioException.class, 
            () -> condominoBusiness.consultarCondominoComFiltros(null, null, null, null));
        verify(condominoService, never()).consultarPorFiltros(any(), any(), any(), any());
    }

    @Test
    void consultarCondominoComFiltros_DeveLancarExcecaoQuandoTodosFiltrosVazios() {
        assertThrows(RegraDeNegocioException.class, 
            () -> condominoBusiness.consultarCondominoComFiltros("", "", "", ""));
        verify(condominoService, never()).consultarPorFiltros(any(), any(), any(), any());
    }
}
