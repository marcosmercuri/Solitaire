class GamePresenter(val view: GameView) {

    fun onTap(modelFunction: () -> Unit) {
        modelFunction()
        view.updateView()
    }

    fun onDeckTap() = onTap { GameModel.onDeckTap() }

    fun onWasteTap() = onTap { GameModel.onWasteTap() }

    fun onFoundationTap(foundationIndex: Int) = onTap { GameModel.onFoundationTap(foundationIndex) }

    fun onTableauTap(tableauIndex: Int, cardIndex: Int) = onTap { GameModel.onTableauTap(tableauIndex, cardIndex) }
}
