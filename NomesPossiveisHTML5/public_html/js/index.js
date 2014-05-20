$(function() {
    $("#nomes").append("Carlos Romel\n");
    $("#nomesMaternos").append("Freitas\n");
    $("#nomesMaternos").append("Correa\n");
    $("#nomesPaternos").append("Pereira\n");
    $("#nomesPaternos").append("da Silva\n");
    $("#btnAdicionarNome").click(function() {
        $("#nomes").append($("#nome").val() + "\n");
        $("#nome").val("");
        $("#nome").focus();
    });

    $("#btnAdicionarNomeMaterno").click(function() {
        $("#nomesMaternos").append($("#nomeMaterno").val() + "\n");
        $("#nomeMaterno").val("");
        $("#nomeMaterno").focus();
    });

    $("#btnAdicionarNomePaterno").click(function() {
        $("#nomesPaternos").append($("#nomePaterno").val() + "\n");
        $("#nomePaterno").val("");
        $("#nomePaterno").focus();
    });

    $("#btnCombinar").click(function() {
        $.each($("#nomes").val().split(/\n/), function(n, nome) {
            $.each($("#nomesMaternos").val().split(/\n/), function(m, nomeMaterno) {
                $.each($("#nomesPaternos").val().split(/\n/), function(p, nomePaterno) {
                    var nomeGerado = nome + " " + nomeMaterno + " " + nomePaterno + "\n";
                    $("#nomesGerados").append(nomeGerado);
                });
            });
        });
    });
})