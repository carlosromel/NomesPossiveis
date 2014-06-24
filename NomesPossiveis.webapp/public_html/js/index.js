/*
 * Copyright (c) 2014 Carlos Romel Pereira da Silva <carlos.romel@gmail.com>
 */
function adicionar(campo, colecao) {
    $(colecao).append($(campo).val() + "\n");
    $(campo).val("");
    $(campo).focus();
}

$(function() {
    $("#btnAdicionarNome").click(function() {
        adicionar("#nome", "#nomes");
    });

    $("#btnAdicionarNomeMaterno").click(function() {
        adicionar("#nomeMaterno", "#nomesMaternos");
    });

    $("#btnAdicionarNomePaterno").click(function() {
        adicionar("#nomePaterno", "#nomesPaternos");
    });

    $("#btnCombinar").click(function() {
        var nomesGerados = "";
        $.each($("#nomes").val().trim().split(/\n/), function(n, nome) {
            $.each($("#nomesMaternos").val().trim().split(/\n/), function(m, nomeMaterno) {
                $.each($("#nomesPaternos").val().trim().split(/\n/), function(p, nomePaterno) {
                    nomesGerados += nome + " " + nomeMaterno + " " + nomePaterno + "\n";
                });
            });
        });

        $("#nomesGerados").val(nomesGerados.trim());
    });
});