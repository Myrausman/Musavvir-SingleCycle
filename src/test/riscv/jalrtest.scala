package riscv
import chisel3._
import org.scalatest._
import chiseltest._
class jalr_test extends FreeSpec with ChiselScalatestTester{
    "jalr test" in {
        test(new jalr){ c =>
        c.io.pc4.poke(0.S)
        c.io.immd_se.poke(0.S)
        c.clock.step(20)
        // c.io.ReadData.expect("b1010101011010101010101010010011".U)
        }
    }
}