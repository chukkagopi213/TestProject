import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.model.ModelService;
import java.util.Set;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.context.annotation.AnnotationConfigUtils;
import org.springframework.stereotype.Component;
import com.borngroup.ssl.fulfilmentprocess.model.InternalConsignmentEntryModel;
import com.borngroup.ssl.fulfilmentprocess.enums.InternalConsignmentEntryStatus;
import java.util.Collection;
import de.hybris.platform.orderprocessing.model.OrderProcessModel;
import de.hybris.platform.processengine.enums.ProcessState;
import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.processengine.BusinessProcessService;
import com.borngroup.ssl.fulfilmentprocess.constants.SslFulfilmentProcessConstants;
import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.ordersplitting.model.ConsignmentEntryModel;
import de.hybris.platform.ordersplitting.model.ConsignmentModel;
import de.hybris.platform.basecommerce.enums.ConsignmentStatus;
import com.borngroup.ssl.fulfilmentprocess.enums.ConsignmentEntryStatus;
import com.borngroup.ssl.fulfilmentprocess.ODCFulfillmentService;
import java.math.BigDecimal;
import java.util.HashMap;


@Component class MyObject {
                @Autowired FlexibleSearchService searchService
                @Autowired ModelService modelService
				@Autowired BusinessProcessService businessProcessService
				
                
}

AutowiredAnnotationBeanPostProcessor aabpp = (AutowiredAnnotationBeanPostProcessor)spring.getBean(AnnotationConfigUtils.AUTOWIRED_ANNOTATION_PROCESSOR_BEAN_NAME)
ODCFulfillmentService odcFulfillmentService = (ODCFulfillmentService) spring.getBean("odcFulfillmentService");
MyObject obj = new MyObject()
aabpp.processInjection(obj)

Set<ConsignmentModel> consignments = obj.searchService.<ConsignmentModel> search(new FlexibleSearchQuery("select {pk} from {consignment} where {code} in ('316-1-134708305')")).getResult()

for(ConsignmentModel consignment : consignments){
  final Map<String, BigDecimal> paymentAmounts = new HashMap<>();
  paymentAmounts.put("IJ", new BigDecimal("899"));
       // place payment mode and corresponding tender amount for tender calculation     
	odcFulfillmentService.billConsignment(consignment, "ecom@whp.co.in");
  	println("Consignment status ="+ consignment.getStatus());
}