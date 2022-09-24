package riscv
import chisel3._
import org.scalatest._
import chiseltest._
class immdgen_test extends FreeSpec with ChiselScalatestTester{
    "immediate generation" in {
        test(new ImmdValGen){ c =>
        c.io.instr.poke("b1010101011010101010101010010011".U)
        c.io.PC.poke(0.U)
        c.clock.step(20)
        c.io.immd_se.expect(1366.S)
        }
    }
}