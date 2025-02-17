package ar.edu.utn.frba.dds.simeal.models.entities.suscripciones.notificacion;

import ar.edu.utn.frba.dds.simeal.models.entities.heladera.Heladera;
import ar.edu.utn.frba.dds.simeal.models.entities.suscripciones.Suscripcion;
import ar.edu.utn.frba.dds.simeal.models.entities.suscripciones.eventos.TipoEvento;
import ar.edu.utn.frba.dds.simeal.utils.notificaciones.Mensaje;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class QuedanPocasViandas implements Notificacion {
  @Override
  public Mensaje getMensaje(Heladera heladera) {
    return new Mensaje("Quedan pocas viandas en la heladera: "
      + heladera.getNombre());
  }

  @Override
  public Boolean interesaEsteEvento(TipoEvento tipoEvento, Suscripcion suscripcion, int cantidadViandas) {
    return tipoEvento.equals(TipoEvento.RETIRO) && suscripcion.getCantidadViandasCriticas() > cantidadViandas;
  }
}
