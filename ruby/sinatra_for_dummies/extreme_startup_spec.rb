require './extreme_startup'

describe ExtremeStartup do

  it "parses numeric question" do
    a = ExtremeStartup.new.answer("what the sum of 4 and 12")
    a.should == "16"
  end

end
