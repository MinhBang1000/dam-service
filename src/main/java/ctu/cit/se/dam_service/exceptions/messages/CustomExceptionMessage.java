package ctu.cit.se.dam_service.exceptions.messages;

public class CustomExceptionMessage {
    public final static String RIVER_NOT_FOUND_BY_ID = "CAN NOT FIND ANY RIVER WITH THIS ID";
    public final static String DAM_TYPE_NOT_FOUND_BY_ID = "CAN NOT FIND ANY DAM TYPE WITH THIS ID";
    public final static String DAM_NOT_FOUND_BY_ID = "CAN NOT FIND ANY DAM WITH THIS ID";
    public final static String DAM_STATUS_NOT_FOUND_BY_ID = "CAN NOT FIND ANY DAM STATUS WITH THIS ID";
    public final static String DAM_STATUS_NOT_FOUND_BY_NAME = "Không thể tìm thấy trạng thái đập nào tương ứng tên này";
    public final static String DAM_SCHEDULE_NOT_FOUND_BY_ID = "CAN NOT FIND ANY DAM SCHEDULE WITH THIS ID";
    public final static String DAM_SCHEDULE_IS_NULL = "THE INPUT DAM SCHEDULE HAS BEEN NULL";
    public final static String DAM_SCHEDULE_BEGIN_END = "CAN NOT CREATE A DAM SCHEDULE WITH BEGIN AT OR END AT IN THE SAME TIME WITH THE EXISTED";
    public final static String DAM_SCHEDULE_BEGIN_END_INVALID = "Ngày bắt đầu phải trước ngày kết thúc";
    public final static String DAM_SCHEDULE_BEGIN_END_INVALID_RANGE = "Đã tồn tại hoạt động trong thời điểm này";
}
