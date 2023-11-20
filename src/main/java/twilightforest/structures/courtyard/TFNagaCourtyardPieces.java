package twilightforest.structures.courtyard;

import net.minecraft.world.gen.structure.MapGenStructureIO;

public class TFNagaCourtyardPieces {
    public static void registerPieces() {
        MapGenStructureIO.func_143031_a(ComponentTFNagaCourtyardMain.class, "TFNCMn");
        MapGenStructureIO.func_143031_a(ComponentTFNagaCourtyardDecorator.class, "TFNCDeco");
        MapGenStructureIO.func_143031_a(ComponentTFNagaCourtyardHedge.class, "TFNCH");
        MapGenStructureIO.func_143031_a(ComponentTFNagaCourtyardHedgePillar.class, "TFNCHP");
        MapGenStructureIO.func_143031_a(ComponentTFNagaCourtyardHedgePadder.class, "TFNCHPd");
        MapGenStructureIO.func_143031_a(ComponentTFNagaCourtyardTerraceAbstract.class, "TFNCTr");
        MapGenStructureIO.func_143031_a(ComponentTFNagaCourtyardTerraceBrazier.class, "TFNCTrB");
        MapGenStructureIO.func_143031_a(ComponentTFNagaCourtyardTerraceDuct.class, "TFNCDu");
        MapGenStructureIO.func_143031_a(ComponentTFNagaCourtyardTerraceDuctPart.class, "TFNCDuPt");
        MapGenStructureIO.func_143031_a(ComponentTFNagaCourtyardTerraceStatue.class, "TFNCSt");
        MapGenStructureIO.func_143031_a(ComponentTFNagaCourtyardTerraceStatueBorder.class, "TFNCStBd");
        MapGenStructureIO.func_143031_a(ComponentTFNagaCourtyardWall.class, "TFNCWl");
        MapGenStructureIO.func_143031_a(ComponentTFNagaCourtyardWallPadder.class, "TFNCWP");
        MapGenStructureIO.func_143031_a(ComponentTFNagaCourtyardWallCornerInner.class, "TFNCWCI");
        MapGenStructureIO.func_143031_a(ComponentTFNagaCourtyardWallCornerInnerPart.class, "TFNCWCIPt");
        MapGenStructureIO.func_143031_a(ComponentTFNagaCourtyardWallCornerOuter.class, "TFNCWCO");
    }
}
