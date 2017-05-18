package br.com.api.cucumber.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;

import br.com.api.cucumber.model.Pessoa;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api/v1/cucumber/pessoa")
public class PessoaController {

	@RequestMapping(method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Criar uma pessoa", notes = "Retorna status do serviço.")
    public void createPessoa(@RequestBody Pessoa pessoa, HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(HttpStatus.CREATED.value());
    }

    @RequestMapping(method = RequestMethod.GET,
            produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Recuperar pessoa", notes = "Recupera pessoa de acordo com CPF.")
    public @ResponseBody Pessoa getPessoaBy(@RequestParam(value = "cpf", required = true) Integer cpf,
                                      HttpServletRequest request, HttpServletResponse response) {
    	if (132456789 == cpf) {
    		return new Pessoa(cpf, "Sthanley", "Rua Faz de Conta", "1111-1111"); 
    	}
    	response.setStatus(HttpStatus.NOT_FOUND.value());
    	response.setHeader("erro: ", "CPF Inválido");
        return null;
    }
}
