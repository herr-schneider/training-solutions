package statemachine.seatheater;

public enum SeatHeaterState {
    THREE {
        SeatHeaterState next() {
            return SeatHeaterState.TWO;
        }
    },
    TWO{
        SeatHeaterState next() {
            return SeatHeaterState.ONE;
        }
    },
    ONE{
        SeatHeaterState next() {
            return SeatHeaterState.OFF;
        }
    },
    OFF{
        SeatHeaterState next() {
            return SeatHeaterState.THREE;
        }
    };


    abstract SeatHeaterState next();
}
