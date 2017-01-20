package Controller;

import divinae.DivinaePandocreonGraphique;

/**
 * Controller Divinae
 */
public class ControllerDivinae {
    private DivinaePandocreonGraphique dpg;

    public void setDpg(DivinaePandocreonGraphique dpg)
    {
        this.dpg=dpg;
    }
    public DivinaePandocreonGraphique getDpg()
    {
        return this.dpg;
    }
}
