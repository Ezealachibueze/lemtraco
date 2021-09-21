package logic;

import java.io.ByteArrayInputStream;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import Serve.UserServer_Request;
import lemtraco02.Creden;

@ManagedBean
@RequestScoped
public class Shop_views {
	
	
					String id,price,writeUp,quantity,total,prices,pics_id;
					List<Shop_views>  list1, list2,list3;
					StreamedContent  content1;
					UserServer_Request  request =new UserServer_Request();
					Nav nav= new Nav();
					
					
					
					
					
			
					
					public String getPics_id() {
						return pics_id;
					}

					public void setPics_id(String pics_id) {
						this.pics_id = pics_id;
					

			}

					public String getQuantity() {
						return quantity;
					}

					public void setQuantity(String quantity) {
						this.quantity = quantity;
					}

					public String getTotal() {
						return total;
					}

					public void setTotal(String total) {
						this.total = total;
					}

					public String getPrices() {
						return prices;
					}

					public void setPrices(String prices) {
						this.prices = prices;
					}

					public String getId() {
						return id;
					}

					public void setId(String id) {
						this.id = id;
					}

					public String getPrice() {
						return price;
					}

					public void setPrice(String price) {
						this.price = price;
					}

					public String getWriteUp() {
						return writeUp;
					}

					public void setWriteUp(String writeUp) {
						this.writeUp = writeUp;
					}

					public UserServer_Request getRequest() {
						return request;
					}

					public void setRequest(UserServer_Request request) {
						this.request = request;
					}

					
					
					
					
					
					
					
					public StreamedContent getContent1() {
						FacesContext  context =FacesContext.getCurrentInstance();
						byte [] cv= null;
						if(context.getCurrentPhaseId()==PhaseId.RENDER_RESPONSE)
								return new DefaultStreamedContent();
					else { String v=(context.getExternalContext().getRequestParameterMap().get("c1"));  cv = request.read_img(Creden.bucket, v);}
						return new   DefaultStreamedContent(new ByteArrayInputStream(cv));
					}

					public void setContent1(StreamedContent content1) {
						this.content1 = content1;
					}

					
					
					public List<Shop_views> getList1() {
						return   request.first_pull();
					}

					public void setList1(List<Shop_views> list1) {
						this.list1 = list1;
					}

				
		
			
					
		
				public String   pricings() {
					
					FacesContext  context =FacesContext.getCurrentInstance();
					 new Sing().setId(Integer.valueOf(context.getExternalContext().getRequestParameterMap().get("cd")));
						request.send_out();
				 return   "/Orders.xhtml?faces-redirect=true";}
					
	
				public List<Shop_views> getList2() {
					return request.send_out();
				}

				public void setList2(List<Shop_views> list2) {
					this.list2 = list2;
				}
				
				
				public List<Shop_views> getList3() {
					return request.view_orders(nav.GETID());
				}

				public void setList3(List<Shop_views> list3) {
					this.list3 = list3;
				}
}
