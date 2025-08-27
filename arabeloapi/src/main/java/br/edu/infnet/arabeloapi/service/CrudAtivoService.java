package br.edu.infnet.arabeloapi.service;

public interface CrudAtivoService<T, ID> {
    T inativar(ID id);
}
