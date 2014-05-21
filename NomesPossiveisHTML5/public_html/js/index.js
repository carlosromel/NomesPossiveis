function adicionar(campo, colecao, total) {
    $(colecao).append($(campo).val() + "\n");
    $(campo).val("");
    $(campo).focus();
    $(total).html($(colecao).val().split(/\n/).length);
}

$(function() {
    $("#nomes").append("Carlos Romel\n");
    $("#nomesMaternos").append("Freitas\n");
    $("#nomesMaternos").append("Correa\n");
    $("#nomesPaternos").append("Pereira\n");
    $("#nomesPaternos").append("da Silva\n");

    $("#btnAdicionarNome").click(function() {
        adicionar("#nome", "#nomes", "#qtdNomes");
    });

    $("#btnAdicionarNomeMaterno").click(function() {
        adicionar("#nomeMaterno", "#nomesMaternos", "#qtdNomesMaternos");
    });

    $("#btnAdicionarNomePaterno").click(function() {
        adicionar("#nomePaterno", "#nomesPaternos", "#qtdNomesPaternos");
    });

    $("#btnCombinar").click(function() {
        var nomesGerados = "";
        $("#nomesGerados").val("Teste\n");
        $.each($("#nomes").val().split(/\n/), function(n, nome) {
            $.each($("#nomesMaternos").val().split(/\n/), function(m, nomeMaterno) {
                $.each($("#nomesPaternos").val().split(/\n/), function(p, nomePaterno) {
                    nomesGerados += nome + " " + nomeMaterno + " " + nomePaterno + "\n";
                });
            });
        });

        $("#nomesGerados").val(nomesGerados);
        $("#qtdNomesGerados").html($("#nomesGerados").val().split(/\n/).length);
    });
})