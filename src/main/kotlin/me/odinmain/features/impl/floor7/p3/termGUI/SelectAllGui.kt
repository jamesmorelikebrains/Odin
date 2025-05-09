package me.odinmain.features.impl.floor7.p3.termGUI

import me.odinmain.OdinMain.mc
import me.odinmain.features.impl.floor7.p3.TerminalSolver
import me.odinmain.features.impl.floor7.p3.TerminalSolver.currentTerm
import me.odinmain.features.impl.floor7.p3.TerminalSolver.customScale
import me.odinmain.features.impl.floor7.p3.TerminalSolver.gap
import me.odinmain.utils.render.*
import me.odinmain.utils.ui.Colors

object SelectAllGui : TermGui() {
    override fun render() {
        setCurrentGui(this)
        itemIndexMap.clear()
        roundedRectangle(-300, -175, 600, 350, TerminalSolver.customGuiColor, 10f, 1f)
        if (TerminalSolver.customGuiText == 0) {
            text("Select All the \"*\" Items!", -295, -163, Colors.WHITE, 20, verticalAlign = TextPos.Top)
            roundedRectangle(-298, -135, getTextWidth("Select All the \"*\" Items!", 20f), 3, Colors.WHITE, radius = 5f)
        } else if (TerminalSolver.customGuiText == 1) {
            text("Select All the \"*\" Items!", 0, -163, Colors.WHITE, 20, align = TextAlign.Middle, verticalAlign = TextPos.Top)
            roundedRectangle(-getTextWidth("Select All the \"*\" Items!", 20f) / 2, -135, getTextWidth("Select All the \"*\" Items!", 20f), 3, Colors.WHITE, radius = 5f)
        }
        currentTerm?.solution?.forEach { pane ->
            val row = pane / 9 - 1
            val col = pane % 9 - 2
            val box = BoxWithClass((-168 + ((gap -20).unaryPlus() * 0.5)) + col * 70, -115 + row * 70, 70 - gap, 70 - gap)
            roundedRectangle(box, TerminalSolver.selectColor)
            itemIndexMap[pane] = Box(
                box.x.toFloat() * customScale + mc.displayWidth / 2,
                box.y.toFloat() * customScale + mc.displayHeight / 2,
                box.w.toFloat() * customScale,
                box.h.toFloat() * customScale
            )
        }
    }
}