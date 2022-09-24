package riscv
import chisel3._
import org.scalatest._
import chiseltest._
class pc_test extends FreeSpec with ChiselScalatestTester{
    "pc" in {
        test(new Pc){ c =>
        c.io.input.poke(0.U)
        c.clock.step(20)
        c.io.pc4.expect(4.U)
        c.io.pc.expect(0.U)
        }
    }
}