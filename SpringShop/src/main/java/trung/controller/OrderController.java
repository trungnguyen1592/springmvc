package trung.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import trung.dao.BillDao;
import trung.model.BillDTO;
import trung.model.BillDetailDTO;
import trung.model.CategoryDTO;
import trung.model.OrderDTO;
import trung.model.OrderItemDTO;
import trung.model.ProductDTO;
import trung.service.BillDetailService;
import trung.service.BillService;
import trung.service.CategoryService;
import trung.service.ProductService;

@Controller
public class OrderController {

	@Autowired
	ProductService productService;
	
	@Autowired
	BillService billService; 
	
	@Autowired
	CategoryService categoryService; 
	
	@Autowired
	BillDetailService billDetailService; 
	
	@Autowired
	BillDao billDao;

	@RequestMapping(value = "/add-to-cart/{productId}", method = RequestMethod.GET)
	public String addToCart(HttpServletRequest request, @PathVariable(name = "productId") int productId,
			HttpSession httpSession) {
		ProductDTO productDTO = productService.getProductById(productId);

		if (httpSession.getAttribute("cart") == null) {
			OrderDTO orderDTO = new OrderDTO();
			OrderItemDTO orderItemDTO = new OrderItemDTO();
			orderItemDTO.setNumber(1);
			orderItemDTO.setProductDTO(productDTO);

			List<OrderItemDTO> orderItemDTOs = new ArrayList<OrderItemDTO>();
			orderItemDTOs.add(orderItemDTO);

			orderDTO.setItemDTOs(orderItemDTOs);

			httpSession.setAttribute("cart", orderDTO);
			httpSession.setAttribute("orderItemDTOs", orderItemDTOs);

			request.setAttribute("order", orderDTO);
		} else {
			OrderDTO orderDTO = (OrderDTO) httpSession.getAttribute("cart");
			List<OrderItemDTO> orderItemDTOs = orderDTO.getItemDTOs();
			boolean flag = false;
			for (OrderItemDTO orderItemDTO : orderItemDTOs) {
				if (orderItemDTO.getProductDTO().getId() == productDTO.getId()) {
					orderItemDTO.setNumber(orderItemDTO.getNumber() + 1);
					flag = true;
				}
			}
			if (!flag) {
				// neu trong gio hang chua co san pham
				OrderItemDTO orderItemDTO = new OrderItemDTO();
				orderItemDTO.setNumber(1);
				orderItemDTO.setProductDTO(productDTO);

				orderItemDTOs.add(orderItemDTO);
			}
			httpSession.setAttribute("cart", orderDTO);

			request.setAttribute("order", orderDTO);
		}
		List<CategoryDTO> categories = categoryService.getAllCategories();
		request.setAttribute("categories", categories);

		return "cart";
	}

	@RequestMapping(value = "/view-cart", method = RequestMethod.GET)
	public String viewCart(HttpServletRequest request, HttpSession httpSession) {

		if (httpSession.getAttribute("cart") != null) {
			OrderDTO orderDTO = (OrderDTO) httpSession.getAttribute("cart");
			request.setAttribute("order", orderDTO);
		}
		List<CategoryDTO> categories = categoryService.getAllCategories();
		request.setAttribute("categories", categories);
		return "cart";

	}
	
	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public String createOrder(HttpServletRequest request, HttpSession httpSession) {

		if (httpSession.getAttribute("cart") != null) {
			
			BillDTO billDTO = new BillDTO();
			int idOrder = (int) new Date().getTime();
			billDTO.setBillId(Math.abs(idOrder));
			billDTO.setDate(new Timestamp(new Date().getTime()));
			billService.addBill(billDTO);
			OrderDTO orderDTO = (OrderDTO) httpSession.getAttribute("cart");
			List<OrderItemDTO> orderItemDTOs = orderDTO.getItemDTOs();
			
			for (int i = 0; i < orderItemDTOs.size(); i++) {
				BillDetailDTO billDetailDTO = new BillDetailDTO();
				billDetailDTO.setBillDetailId(idOrder);
				billDetailDTO.setProductId(orderItemDTOs.get(i).getProductDTO().getId());
				billDetailDTO.setPrice(orderItemDTOs.get(i).getProductDTO().getPrice());
				billDetailDTO.setQuantity(orderItemDTOs.get(i).getNumber());
				billDetailService.addBillDetail(billDetailDTO,Math.abs(idOrder));
				
			}
			httpSession.removeAttribute("cart");
		}
		return "redirect:/";

	}

	@RequestMapping(value = "/delete-cart/{productId}", method = RequestMethod.GET)
	public String deleteCart(HttpServletRequest request, HttpSession httpSession,
			@PathVariable(name = "productId") int productId) {

		if (httpSession.getAttribute("cart") != null) {
			OrderDTO orderDTO = (OrderDTO) httpSession.getAttribute("cart");
			List<OrderItemDTO> orderItemDTOs = orderDTO.getItemDTOs();

			Iterator<OrderItemDTO> iterator = orderItemDTOs.iterator();
			while (iterator.hasNext()) {
				if (iterator.next().getProductDTO().getId() == productId) {
					iterator.remove();
				}
			}
			if (orderItemDTOs.isEmpty()) {
				httpSession.removeAttribute("cart");
			}

			request.setAttribute("order", orderDTO);
		}
		return "cart";

	}
}
