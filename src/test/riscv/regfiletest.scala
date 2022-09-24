package riscv
import chisel3._
import org.scalatest._
import chiseltest._
class regfile_test extends FreeSpec with ChiselScalatestTester{
    "reg file" in {
        test(new RegFile){ c =>
        c.io.RegWrite.poke(1.U)
        c.io.reg1.poke(0.U)
        c.io.reg2.poke(1.U)
        c.io.rd.poke(0.U)
        c.io.WriteData.poke(0.S)
        c.clock.step(20)
        // c.io.rs1.expect(0.S)
        // c.io.rs2.expect(0.S)
        }
    }
}