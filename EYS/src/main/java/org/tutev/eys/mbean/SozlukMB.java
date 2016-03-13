package org.tutev.eys.mbean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.tutev.envanterys.TDbException;
import org.tutev.envanterys.entity.Sozluk;
import org.tutev.envanterys.entity.enm.SozlukTip;
import org.tutev.envanterys.framework.PageModel;
import org.tutev.envanterys.service.SozlukService;

@ManagedBean(name = "sozlukMB")
@ViewScoped
public class SozlukMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3421343394633338633L;

	@ManagedProperty(value = "#{sozlukService}")
	private SozlukService sozlukService;

	LazyDataModel<Sozluk> lazy;
	private Sozluk sozluk;

	@PostConstruct
	private void init() {
		listele();
	}

	public void kaydet() {
		try {
			if (sozluk.getId() == null || sozluk.getId() < 1L)
				sozlukService.save(sozluk);
			else
				sozlukService.update(sozluk);

			listele();
			sozluk = new Sozluk();
			FacesContext.getCurrentInstance().addMessage( null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Kayıt Başarılı", "Kişi Kaydedildi"));
		} catch (TDbException e) {
			FacesContext.getCurrentInstance().addMessage( null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Hata", e.getMessage()));
			e.printStackTrace();
		}
	}

	public void sil(Long id) {
		Sozluk silinecek = sozlukService.getById(id);
		sozlukService.delete(silinecek);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Silme",
						"Kişi Silindi"));
		listele();
	}

	public SozlukTip[] getSozlukTipList() {
		return SozlukTip.values();
	}

	public void onRowSelect(SelectEvent event) {
		this.sozluk = (Sozluk) event.getObject();
	}

	public void setSozlukService(SozlukService sozlukService) {
		this.sozlukService = sozlukService;
	}

	public Sozluk getSozluk() {
		if (sozluk == null) {
			sozluk = new Sozluk();
		}
		return sozluk;
	}

	public void setSozluk(Sozluk sozluk) {
		this.sozluk = sozluk;
	}

	private void listele() {
		lazy = new LazyDataModel<Sozluk>() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1777988557181936414L;

			@SuppressWarnings("unchecked")
			@Override
			public List<Sozluk> load(int first, int pageSize, String sortField,
					SortOrder sortOrder, Map<String, Object> filters) {

				PageModel mdl = sozlukService.getByPaging(first, pageSize,
						filters);

				lazy.setRowCount(mdl.getRowCount());

				return (List<Sozluk>) mdl.getList();
			}

			@Override
			public Sozluk getRowData(String rowKey) {
				return sozlukService.getById(Long.parseLong(rowKey));
			}

		};
	}

	public LazyDataModel<Sozluk> getLazy() {
		return lazy;
	}
}
