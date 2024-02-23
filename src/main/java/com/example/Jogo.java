package com.example;

public class Jogo {
    protected Monte monte = new Monte();
    protected Jogador jogador = new Jogador();
    protected Computador computador = new Computador();

    public Jogo(){
        monte.embaralhar();
    }

    public Carta distribuirCartaParaJogador(Jogador jogador){
        //early return
        if (jogador.parou()) return null;
        
        var carta = monte.virar();
        jogador.receberCarta(carta);
        return carta;
    }

    public boolean acabou(){
        var osDoisPararam = jogador.parou() && computador.parou();
        
        return osDoisPararam || jogador.estourou() || computador.estourou();
    }

    public String resultado(){
        var pontosIguais = jogador.getPontos() == computador.getPontos();
        var osDoisEntouraram = jogador.estourou() && computador.estourou();
        var jogadorTemMaisPontos = jogador.getPontos() > computador.getPontos();

        if( pontosIguais || osDoisEntouraram ) return "Empatou";
        if( !jogador.estourou() && (computador.estourou() || jogadorTemMaisPontos) ) return "Você Ganhou!";
        return "Você Perdeu!"; 
        
    }

}
